package br.com.uniportal.shared.configurator;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.bson.UuidRepresentation;
import org.bson.codecs.UuidCodec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
@Deprecated
public class MongoConfigurator extends AbstractMongoConfiguration {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Value("${spring.data.mongodb.serverSelectionTimeout:10000}")
    private int serverSelectionTimeout = 10_000;

    @Value("${spring.data.mongodb.connectTimeout:3000}")
    private int connectTimeout = 3000;

    @Value("${spring.data.mongodb.maxWaitTime:5000}")
    private int maxWaitTime = 5000;

    @Value("${spring.data.mongodb.maxConnectionLifeTime:360000}")
    private int maxConnectionLifeTime = 360_000;

    @Value("${spring.data.mongodb.maxConnectionIdleTime:60000}")
    private int maxConnectionIdleTime = 60000;
    
    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    private CodecRegistry createCodecRegistries() {
        // save UUID using standard 4 bytes representation
        return CodecRegistries.fromRegistries(CodecRegistries.fromCodecs(new UuidCodec(UuidRepresentation.STANDARD)), MongoClient.getDefaultCodecRegistry());
    }

    @Override
    public MongoClient mongoClient() {
        MongoClientOptions.Builder mcoBuilder = MongoClientOptions
                .builder()
                .applicationName(applicationName)
                .serverSelectionTimeout(serverSelectionTimeout)
                .connectTimeout(connectTimeout)
                .maxWaitTime(maxWaitTime)
                .maxConnectionLifeTime(maxConnectionLifeTime)
                .maxConnectionIdleTime(maxConnectionIdleTime)
                .codecRegistry(createCodecRegistries());
        return new MongoClient(new MongoClientURI(uri, mcoBuilder));
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) throws Exception {
        // remove _class
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        converter.afterPropertiesSet();
        return new MongoTemplate(mongoDbFactory, converter);
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }
}


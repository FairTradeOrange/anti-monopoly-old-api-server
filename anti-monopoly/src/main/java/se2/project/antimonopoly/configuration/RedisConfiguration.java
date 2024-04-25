package se2.project.antimonopoly.configuration;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfiguration {

    @Value("${spring.data.redis.host}")
    private String redisHost;

    private @Value("${spring.data.redis.port}")
    int redisPort;

    private @Value("${spring.data.redis.timeout}")
    Duration redisCommandTimeout;

    private @Value("${spring.data.redis.custom.socket.timeout}")
    Duration socketTimeout;

    @Bean
    public RedisTemplate<?, ?> redisTemplate( RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<?, ?> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplateObject(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }

//    @Bean
//    public StringRedisTemplate redisTemplateOld(LettuceConnectionFactory lettuceConnectionFactory) {
//        final StringRedisTemplate template = new StringRedisTemplate();
//        template.setConnectionFactory(lettuceConnectionFactory);
//        return template;
//    }

    //Creating Connection with Redis
   // @Bean
   //  public RedisConnectionFactory redisConnectionFactory() {
   //     return new LettuceConnectionFactory();
   // }

    //Creating RedisTemplate for Entity 'RedisUser'
  //  @Bean
  //  public RedisTemplate<String, UserRedis> redisUserTemplate(){
  //      RedisTemplate<String, UserRedis> empTemplate = new RedisTemplate<>();
  //      empTemplate.setConnectionFactory(lettuceConnectionFactory());
  //      return empTemplate;
  //  }
    
    @Bean
    LettuceConnectionFactory lettuceConnectionFactory() {
        final SocketOptions socketOptions = SocketOptions.builder().connectTimeout(socketTimeout).build();
        final ClientOptions clientOptions = ClientOptions.builder().socketOptions(socketOptions).build();

        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .commandTimeout(redisCommandTimeout)
                .clientOptions(clientOptions).build();

        RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration(redisHost, redisPort);

        final LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(serverConfig, clientConfig);
        lettuceConnectionFactory.setValidateConnection(true);
        //return new LettuceConnectionFactory(serverConfig, clientConfig);
        return lettuceConnectionFactory;
    }

}
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 应用配置属性
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Data
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

}

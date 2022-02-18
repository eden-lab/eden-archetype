#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.adapter.constant;

import lombok.experimental.UtilityClass;

/**
 * API 常量定义
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@UtilityClass
public class ApiConstant {

	public static final String WEB_API_PATH = "/api";

	public static final int DEFAULT_TIMEOUT = 3000;
}

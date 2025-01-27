#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.dto;

import lombok.*;
import org.ylzl.eden.spring.framework.dto.PageQuery;

/**
 * 用户分页查询（数据传输对象）
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@NoArgsConstructor // 扩展的时候需要重新定义无参构造
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserPageQuery extends PageQuery {

	private String login;
}

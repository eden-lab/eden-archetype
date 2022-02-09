#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.user.dto.query;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 根据分页查询获取用户列表指令
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class UserByIdQry implements Serializable {

	@NotNull(message = "用户ID 不能为空")
	private Long userId;
}

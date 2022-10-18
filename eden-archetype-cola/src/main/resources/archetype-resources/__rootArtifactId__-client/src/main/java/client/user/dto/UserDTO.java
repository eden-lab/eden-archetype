#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.user.dto;

import lombok.*;

import java.io.Serializable;

/**
 * 用户（数据传输对象）
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class UserDTO implements Serializable {

	/**
	 * 用户ID
	 */
	private Long id;

	/**
	 * 用户账号
	 */
	private String login;

	/**
	 * 用户邮箱
	 */
	private String email;
}

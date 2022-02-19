#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api;

import org.ylzl.eden.spring.framework.cola.dto.PageResponse;
import org.ylzl.eden.spring.framework.cola.dto.Response;
import org.ylzl.eden.spring.framework.cola.dto.SingleResponse;
import ${package}.api.dto.UserDTO;
import ${package}.api.dto.UserPageQuery;
import ${package}.api.dto.UserVO;

/**
 * 用户业务逻辑接口
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public interface UserService {

	/**
	 * 创建用户
	 *
	 * @param dto
	 */
	Response createUser(UserDTO dto);

	/**
	 * 修改用户
	 *
	 * @param id
	 * @param dto
	 */
	Response modifyUser(Long id, UserDTO dto);

	/**
	 * 删除用户
	 *
	 * @param id
	 */
	Response removeUser(Long id);

	/**
	 * 获取用户信息
	 *
	 * @param id
	 * @return
	 */
	SingleResponse<UserVO> getUserById(Long id);

	/**
	 * 获取用户分页
	 *
	 * @param query
	 * @return
	 */
	PageResponse<UserVO> listUserByPage(UserPageQuery query);
}

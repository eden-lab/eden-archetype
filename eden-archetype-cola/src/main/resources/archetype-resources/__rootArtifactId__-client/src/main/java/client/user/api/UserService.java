#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.user.api;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import ${package}.client.user.dto.UserVO;
import ${package}.client.user.dto.command.UserAddCmd;
import ${package}.client.user.dto.command.UserModifyCmd;
import ${package}.client.user.dto.command.UserRemoveCmd;
import ${package}.client.user.dto.query.UserByIdQry;
import ${package}.client.user.dto.query.UserListByPageQry;

/**
 * 用户领域业务接口
 *
 * @author gyl
 * @since 2.4.x
 */
public interface UserService {

	/**
	 * 创建用户
	 *
	 * @param cmd
	 */
	Response createUser(UserAddCmd cmd);

	/**
	 * 修改用户
	 *
	 * @param cmd
	 */
	Response modifyUser(UserModifyCmd cmd);

	/**
	 * 删除用户
	 *
	 * @param cmd
	 */
	Response removeUser(UserRemoveCmd cmd);

	/**
	 * 获取用户信息
	 *
	 * @param query
	 * @return
	 */
	SingleResponse<UserVO> getUserById(UserByIdQry query);

	/**
	 * 获取用户分页
	 *
	 * @param query
	 * @return
	 */
	PageResponse<UserVO> listUserByPage(UserListByPageQry query);
}

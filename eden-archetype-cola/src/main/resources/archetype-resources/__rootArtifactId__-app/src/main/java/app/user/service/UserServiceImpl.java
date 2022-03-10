#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${package}.app.user.executor.command.UserAddCmdExe;
import ${package}.app.user.executor.command.UserModifyCmdExe;
import ${package}.app.user.executor.command.UserRemoveCmdExe;
import ${package}.app.user.executor.query.UserByIdQryExe;
import ${package}.app.user.executor.query.UserListByPageQryExe;
import ${package}.client.user.api.UserService;
import ${package}.client.user.dto.UserDTO;
import ${package}.client.user.dto.command.UserAddCmd;
import ${package}.client.user.dto.command.UserModifyCmd;
import ${package}.client.user.dto.command.UserRemoveCmd;
import ${package}.client.user.dto.query.UserByIdQry;
import ${package}.client.user.dto.query.UserListByPageQry;
import org.ylzl.eden.spring.framework.cola.dto.PageResponse;
import org.ylzl.eden.spring.framework.cola.dto.Response;
import org.ylzl.eden.spring.framework.cola.dto.SingleResponse;

/**
 * 用户领域业务实现
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
//@DS("ds2") // 多数据源示例
@RequiredArgsConstructor
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {

	private final UserAddCmdExe userAddCmdExe;

	private final UserModifyCmdExe userModifyCmdExe;

	private final UserRemoveCmdExe userRemoveCmdExe;

	private final UserByIdQryExe userByIdQryExe;

	private final UserListByPageQryExe userListByPageQryExe;

	/**
	 * 创建用户
	 *
	 * @param cmd
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Response createUser(UserAddCmd cmd) {
		return userAddCmdExe.execute(cmd);
	}

	/**
	 * 修改用户
	 *
	 * @param cmd
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Response modifyUser(UserModifyCmd cmd) {
		return userModifyCmdExe.execute(cmd);
	}

	/**
	 * 删除用户
	 *
	 * @param cmd
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Response removeUser(UserRemoveCmd cmd) {
		this.getUserById(UserByIdQry.builder().id(cmd.getId()).build());
		return userRemoveCmdExe.execute(cmd);
	}

	/**
	 * 获取用户信息
	 *
	 * @param query
	 * @return
	 */
	@Override
	public SingleResponse<UserDTO> getUserById(UserByIdQry query) {
		return userByIdQryExe.execute(query);
	}

	/**
	 * 获取用户分页
	 *
	 * @param query
	 * @return
	 */
	@Override
	public PageResponse<UserDTO> listUserByPage(UserListByPageQry query) {
		return userListByPageQryExe.execute(query);
	}
}

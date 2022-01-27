#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.user.gateway;

import ${package}.domain.user.entity.User;
import ${package}.domain.user.gateway.UserGateway;
import ${package}.infrastructure.user.database.convertor.UserConvertor;
import ${package}.infrastructure.user.database.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * 用户领域防腐层实现
 *
 * @author gyl
 * @since 2.4.x
 */
@Repository
public class UserGatewayImpl implements UserGateway {

	private final UserMapper userMapper;

	public UserGatewayImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 新增用户
	 *
	 * @param user
	 */
	@Override
	public void save(User user) {
		userMapper.insert(UserConvertor.INSTANCE.toDataObject(user));
	}

	/**
	 * 修改用户
	 *
	 * @param user
	 */
	@Override
	public void updateById(User user) {
		userMapper.updateById(UserConvertor.INSTANCE.toDataObject(user));
	}

	/**
	 * 删除用户
	 *
	 * @param user
	 */
	@Override
	public void deleteById(User user) {
		userMapper.deleteById(user.getUserId());
	}
}
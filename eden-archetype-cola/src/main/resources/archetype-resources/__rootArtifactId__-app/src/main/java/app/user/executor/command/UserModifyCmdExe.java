#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.user.executor.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ${package}.app.user.assembler.UserAssembler;
import ${package}.client.user.dto.command.UserModifyCmd;
import ${package}.domain.user.entity.User;
import ${package}.domain.user.gateway.UserGateway;
import org.ylzl.eden.spring.framework.cola.dto.Response;

/**
 * 修改用户指令执行器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@RequiredArgsConstructor
@Slf4j
@Component
public class UserModifyCmdExe {

	private final UserGateway userGateway;

	private final UserAssembler userAssembler;

	public Response execute(UserModifyCmd cmd) {
		User user = userAssembler.toEntity(cmd);
		userGateway.updateById(user);
		return Response.buildSuccess();
	}
}

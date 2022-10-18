#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.user.service

import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.slf4j.Logger
import ${package}.app.user.executor.command.UserAddCmdExe
import ${package}.app.user.executor.command.UserModifyCmdExe
import ${package}.app.user.executor.command.UserRemoveCmdExe
import ${package}.app.user.executor.query.UserByIdQryExe
import ${package}.app.user.executor.query.UserListByPageQryExe
import ${package}.client.user.dto.UserDTO
import ${package}.client.user.dto.command.UserAddCmd
import ${package}.client.user.dto.command.UserModifyCmd
import ${package}.client.user.dto.command.UserRemoveCmd
import ${package}.client.user.dto.query.UserByIdQry
import ${package}.client.user.dto.query.UserListByPageQry
import org.ylzl.eden.spring.framework.cola.dto.PageResponse
import org.ylzl.eden.spring.framework.cola.dto.Response
import org.ylzl.eden.spring.framework.cola.dto.SingleResponse
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.any
import static org.mockito.Mockito.when

class UserServiceImplTest extends Specification {
	@Mock
	UserAddCmdExe userAddCmdExe
	@Mock
	UserModifyCmdExe userModifyCmdExe
	@Mock
	UserRemoveCmdExe userRemoveCmdExe
	@Mock
	UserByIdQryExe userByIdQryExe
	@Mock
	UserListByPageQryExe userListByPageQryExe
	@Mock
	Logger log
	@InjectMocks
	UserServiceImpl userServiceImpl

	def setup() {
		MockitoAnnotations.openMocks(this)
	}

	def "test create User"() {
		given:
		when(userAddCmdExe.execute(any())).thenReturn(Response.buildSuccess())

		when:
		Response result = userServiceImpl.createUser(new UserAddCmd("login", "password", "email"))

		then:
		result == Response.buildSuccess()
	}

	def "test modify User"() {
		given:
		when(userModifyCmdExe.execute(any())).thenReturn(Response.buildSuccess())

		when:
		Response result = userServiceImpl.modifyUser(new UserModifyCmd(1l, "login", "password", "email"))

		then:
		result == Response.buildSuccess()
	}

	def "test remove User"() {
		given:
		when(userRemoveCmdExe.execute(any())).thenReturn(Response.buildSuccess())
		when(userByIdQryExe.execute(any())).thenReturn(SingleResponse.of(UserDTO.builder().id(1L).build()))

		when:
		Response result = userServiceImpl.removeUser(new UserRemoveCmd(1l))

		then:
		result == Response.buildSuccess()
	}

	def "test get User By Id"() {
		given:
		when(userByIdQryExe.execute(any())).thenReturn(SingleResponse.of(UserDTO.builder().id(1L).build()))

		when:
		SingleResponse<UserDTO> result = userServiceImpl.getUserById(new UserByIdQry(1l))

		then:
		result == SingleResponse.of(UserDTO.builder().id(1L).build())
	}

	def "test list User By Page"() {
		given:
		when(userListByPageQryExe.execute(any())).thenReturn(PageResponse.of([new UserDTO(1l, "login", "email")], 1, 1, 1))

		when:
		PageResponse<UserDTO> result = userServiceImpl.listUserByPage(new UserListByPageQry("login", "email"))

		then:
		result == PageResponse.of([new UserDTO(1l, "login", "email")], 1, 1, 1)
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum${symbol_pound}!/testme

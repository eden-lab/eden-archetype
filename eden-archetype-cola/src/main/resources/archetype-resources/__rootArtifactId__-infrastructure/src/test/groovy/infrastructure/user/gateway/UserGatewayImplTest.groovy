#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.user.gateway

import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.slf4j.Logger
import ${package}.domain.user.entity.User
import ${package}.infrastructure.user.database.convertor.UserConvertor
import ${package}.infrastructure.user.database.dataobject.UserDO
import ${package}.infrastructure.user.database.mapper.UserMapper
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.any
import static org.mockito.Mockito.when

class UserGatewayImplTest extends Specification {
	@Mock
	UserMapper userMapper
	@Mock
	UserConvertor userConvertor
	@Mock
	Logger log
	@InjectMocks
	UserGatewayImpl userGatewayImpl

	def setup() {
		MockitoAnnotations.openMocks(this)
	}

	def "test save"() {
		given:
		when(userConvertor.toDataObject(any())).thenReturn(UserDO.builder().id(1L).login("login").email("email").passwordHash("password").build())

		when:
		userGatewayImpl.save(new User(1l, "login", "email", "password"))

		then:
		true
	}

	def "test update By Id"() {
		given:
		when(userConvertor.toDataObject(any())).thenReturn(UserDO.builder().id(1L).login("login").email("email").passwordHash("password").build())

		when:
		userGatewayImpl.updateById(new User(1l, "login", "email", "password"))

		then:
		true
	}

	def "test delete By Id"() {
		when:
		userGatewayImpl.deleteById(new User(1l, "login", "email", "password"))

		then:
		true
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum${symbol_pound}!/testme

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.converter;

import ${package}.api.dto.UserDTO;
import ${package}.api.dto.UserVO;
import ${package}.dao.dataobject.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户转换器
 *
 * @author gyl
 * @since 2.4.x
 */
@Mapper(componentModel = "spring",
	nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserConvertor {

	UserConvertor INSTANCE = Mappers.getMapper(UserConvertor.class);

	UserDO dtoToDataObject(UserDTO dto);

	void updateDataObjectFromDTO(UserDTO dto, @MappingTarget UserDO dataObject);

	UserVO dataObjectToVO(UserDO dataObject);

	List<UserVO> dataObjectListToVOList(List<UserDO> dataObjectList);
}
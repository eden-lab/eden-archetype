import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.ylzl.eden.spring.framework.cola.dto.DTOAssembler;

import java.util.List;

/**
 * 用户领域组装器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Mapper(componentModel = "spring",
	nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserAssembler extends DTOAssembler<UserDTO, User> {

	/**
	 * DO 转 VO
	 *
	 * @param dataObject
	 * @return
	 */
	UserDTO toDTO(UserDO dataObject);

	/**
	 * DO 转 VO
	 *
	 * @param dataObjectList
	 * @return
	 */
	List<UserDTO> toDTOList(List<UserDO> dataObjectList);

	/**
	 * DTO 转 Entity
	 *
	 * @param cmd
	 * @return
	 */
	User toEntity(UserAddCmd cmd);

	/**
	 * DTO 转 Entity
	 *
	 * @param cmd
	 * @return
	 */
	User toEntity(UserModifyCmd cmd);

	/**
	 * DTO 转 Entity
	 *
	 * @param cmd
	 * @return
	 */
	User toEntity(UserRemoveCmd cmd);
}

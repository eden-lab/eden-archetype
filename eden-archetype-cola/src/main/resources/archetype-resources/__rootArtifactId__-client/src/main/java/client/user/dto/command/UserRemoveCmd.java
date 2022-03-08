import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 删除用户指令
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class UserRemoveCmd implements Serializable {

	@NotNull(message = "用户ID 不能为空")
	private Long id;
}

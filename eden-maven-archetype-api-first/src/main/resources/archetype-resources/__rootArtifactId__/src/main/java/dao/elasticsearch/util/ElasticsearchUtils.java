#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.elasticseach.util;

import com.baomidou.mybatisplus.annotation.TableName;
import ${package}.dao.enums.SortRuleEnum;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

/**
 * Mybatis 工具集
 *
 * @author gyl
 * @since 0.0.1
 */
@UtilityClass
public class ElasticsearchUtils {

	/**
	 * 获取索引名称
	 *
	 * @param clazz domain
	 * @return
	 */
	public static String getIndex(Class<?> clazz) {
		TableName tableName = clazz.getAnnotation(TableName.class);
		return tableName.value();
	}

	/**
	 * 排序
	 *
	 * @param queryBuilder
	 * @param sortColumn
	 * @param sortRule
	 */
	public static void sort(NativeSearchQueryBuilder queryBuilder, String sortColumn, String sortRule) {
		if (StringUtils.isBlank(sortRule) || StringUtils.isBlank(sortRule)) {
			return;
		}
		queryBuilder.withSort(
			SortBuilders.fieldSort(sortColumn)
				.order(SortRuleEnum.DESC.name().equalsIgnoreCase(sortRule) ? SortOrder.DESC :
					SortOrder.ASC));
	}

	/**
	 * 分页
	 *
	 * @param queryBuilder
	 * @param pageNum
	 * @param pageSize
	 */
	public static Pageable pageable(NativeSearchQueryBuilder queryBuilder,
															@NonNull Long pageNum, @NonNull Long pageSize) {
		Pageable pageable = PageRequest.of(pageNum.intValue() <= 0? 0 :
				pageNum.intValue() - 1,
			pageSize.intValue());
		queryBuilder.withPageable(pageable);
		return pageable;
	}

	/**
	 * 设置返回的字段
	 *
	 * @param queryBuilder
	 * @param includes
	 * @param excludes
	 */
	public static void sourceFilter(NativeSearchQueryBuilder queryBuilder,
																	String[] includes, String[] excludes) {
		queryBuilder.withSourceFilter(new FetchSourceFilter(includes, excludes));
	}

	/**
	 * 设置返回的字段
	 *
	 * @param queryBuilder
	 * @param includes
	 */
	public static void sourceFilter(NativeSearchQueryBuilder queryBuilder,
																	String... includes) {
		sourceFilter(queryBuilder, includes, null);
	}
}

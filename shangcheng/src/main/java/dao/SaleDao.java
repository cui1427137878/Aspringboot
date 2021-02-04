package dao;

import com.sample.Sale;

import javax.annotation.Resource;

/**
 * ClassName:SaleDao
 * Package:dao
 * Description:
 *
 * @Data:2020/11/3 19:11
 * Author:崔建新
 */
@Resource
public interface SaleDao {
    //增加销售记录
    int insertSale(Sale sale);
}

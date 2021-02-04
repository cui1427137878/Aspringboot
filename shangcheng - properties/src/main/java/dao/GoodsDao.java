package dao;

import com.sample.Goods;

import javax.annotation.Resource;

/**
 * ClassName:GoodsDao
 * Package:dao
 * Description:
 *
 * @Data:2020/11/3 19:22
 * Author:崔建新
 */
@Resource
public interface GoodsDao {
    //更新库存
    int updateGoods(Goods goods);
    //查询信息
    Goods selectGoods(Integer id);

}

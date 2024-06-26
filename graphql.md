# graphql
## graphql 分页
+ 偏移分页
  + 使用偏移和限制，指定起始偏移量（要跳过的记录数的）和要返回的最大记录数，如 mysql 分页参数，效果上与页面分页相同
  + 实例参数：`offset=0 and limit=10`
+ 基于光标的分页
  + 使用游标（通常是表示记录的编码值，如 id）来确定数据集中的位置
  + 游标可以是 ID、时间戳或唯一标识记录的任意其他值
  + 示例参数：`cursor=id and limit=10`
  无法按页获取数据
+ 基于页面的分页
  + 此模式将数据集划分多个页面，每个页面包含固定数量的记录
  + 它使用页码浏览数据集，通常使用指示上一页、下一页和当前页的链接或元数据
  + 示例参数：`page=1 and size=10`
+ 基于时间的分页
  + 使用基于时间的边界（如开始时间和结束时间）来提取特定时间范围内的记录
  + 通常用于数据集按时间排序的场景，例如日志或社交媒体帖子
  + 示例参数：`start_time=1111111 and end_time=2222222`
+ 键集分页
  + 依赖于按一列或多列对数据集进行排序，并使用列值作为分页键
  + 每个页面请求都包含上一页中最后一条记录的键，并且 API 返回大于该键的记录
  + 示例参数：`last_key=1234 and limit=10`
+ 模式组合
  + 根据 API 的要求和要求分页的数据的性质组合不同的分页模式
  + 例如。可以使用基于光标的分页进行实时更新，并使用键集分页来高校检索大型数据
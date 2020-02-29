package com.example.antexplorer.dao;

import com.example.antexplorer.pojo.po.Article;
import com.example.antexplorer.pojo.po.ArticleAccessory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 吴山烤禽
 * @package com.example.antexplorer.dao
 * @time 17:32
 * @discribe
 * @since 2020/2/26
 **/
@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
@Component
public interface ArticalMapper {
    @Select("Select * from article Where A_Id=#{AId}")
    Article selectByPrimaryKey(int AId);
    @Select("Select * from article Where A_Title=#{aName}")
    List<Article> selectByTitle(String aName);
    @Insert("Insert into article VALUES(#{A_Id},#{A_Pic},#{A_Content},#{A_Title},#{A_Author},#{A_Time},#{A_Article})")
    int InsertIntoArtical(Article article);
    @Select("Select * from article Where A_Author=#{authorId}")
    List<Article> selectByAuthorId(int authorId);
    @Select("Select M_Content from accessory Where A_Id=#{articleId}")
    List<byte[]> selectPicByArticalId(int articleId);
    @Insert("Insert into accessory VALUES(#{M_Id},#{A_Id},#{M_Content})")
    int insertIntoArticleContent(ArticleAccessory articleAccessory);

}

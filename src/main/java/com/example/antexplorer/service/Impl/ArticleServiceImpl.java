package com.example.antexplorer.service.Impl;

import com.example.antexplorer.dao.ArticalMapper;
import com.example.antexplorer.dao.UserMapper;
import com.example.antexplorer.exception.BizException;
import com.example.antexplorer.pojo.dto.ArticleInfoDTO;
import com.example.antexplorer.pojo.po.Article;
import com.example.antexplorer.pojo.po.ArticleAccessory;
import com.example.antexplorer.pojo.po.user.User;
import com.example.antexplorer.service.ArticleService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author 吴山烤禽
 * @package com.example.antexplorer.service.Impl
 * @time 18:08
 * @discribe
 * @since 2020/2/26
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired(required = false)
    ArticalMapper articalMapper;
    @Autowired(required = false)
    UserMapper userMapper;
    @Override
    public ArticleInfoDTO selectByPrimaryKey(int AId)
    {
        Article article =new Article();
        article =articalMapper.selectByPrimaryKey(AId);


        ArticleInfoDTO res=new ArticleInfoDTO();
        if (article !=null)
        {
            User user=userMapper.selectUserByPrimaryKey(article.getA_Author());
            res.setAContent(article.getAContent());
            String sImgInfo=Base64.getEncoder().encodeToString(article.getAPic());
            res.setAPic(sImgInfo);
            res.setaAuthorId(article.getA_Author());
            res.setaDateTime(article.getA_DateTime());
            res.setaAuthorName(user.getU_Name());
            res.setaAuthorImg(Base64.getEncoder().encodeToString(user.getU_Img()));
            res.setaId(article.getAId());
            res.setA_Name(article.getA_Title());
            res.setaInnerArticle(article.getA_Article());
        }
        return res;
    }
    @Override
    public List<ArticleInfoDTO> selectByTitle(String title)
    {
        List<Article> list=new ArrayList<>();
        list=articalMapper.selectByTitle(title);
        List<ArticleInfoDTO> res=new ArrayList<>();
        if (list.size()==0) throw new BizException("查无此标题的文章");
        for (int i=0;i<list.size();i++)
        {
            ArticleInfoDTO tempDTO=new ArticleInfoDTO();
            Article tmpArticle =list.get(i);
            String sImgInfo=Base64.getEncoder().encodeToString(tmpArticle.getAPic());
            User user=userMapper.selectUserByPrimaryKey(tmpArticle.getA_Author());
            tempDTO.setAPic(sImgInfo);
            tempDTO.setAContent(tmpArticle.getAContent());
            tempDTO.setA_Name(tmpArticle.getA_Title());
            tempDTO.setaDateTime(tmpArticle.getA_DateTime());
            tempDTO.setaId(tmpArticle.getAId());
            tempDTO.setaAuthorName(user.getU_Name());
            tempDTO.setaAuthorImg(Base64.getEncoder().encodeToString(user.getU_Img()));
            tempDTO.setaAuthorId(tmpArticle.getA_Author());

            res.add(tempDTO);
        }
        return res;
    }
    @Override
    public int insertArtical(ArticleInfoDTO articleInfoDTO, int Id)
    {
        Article insertArticle =new Article();
        String ImgInfo= articleInfoDTO.getAPic();
        List<String> contentList=new ArrayList<>();
        contentList=articleInfoDTO.getArticleAccessoryList();
        if (ImgInfo=="")
        {
            if (contentList==null){throw new BizException("起码上传一张图片");}
            ImgInfo=contentList.get(0);
        }
        ImgInfo.replace(" ", "+");
        byte[] B_ImgInfo= Base64.getDecoder().decode(ImgInfo);
        insertArticle.setAId(Id);
        insertArticle.setAPic(B_ImgInfo);
        insertArticle.setAContent(articleInfoDTO.getAContent());
        insertArticle.setA_Title(articleInfoDTO.getA_Name());
        insertArticle.setA_DateTime(articleInfoDTO.getaDateTime());
        insertArticle.setA_Author(articleInfoDTO.getaAuthorId());
        insertArticle.setA_Article(articleInfoDTO.getaInnerArticle());
        articalMapper.InsertIntoArtical(insertArticle);

        for (int i=0;i<contentList.size();i++)
        {
            ArticleAccessory articleAccessory=new ArticleAccessory();
            articleAccessory.setA_Id(Id);
            long l = System.currentTimeMillis();
            List<byte[]> listString;
            int accessoryId;
            //检测是否有相同值的文章附件主键
            do {
                l = System.currentTimeMillis();
                accessoryId = (int) (l % 1000);
                listString=articalMapper.selectPicByArticalId(accessoryId);
            }
            while (listString.size()>0);
            articleAccessory.setM_Id(accessoryId);
            articleAccessory.setM_Content(Base64.getDecoder().decode(contentList.get(i)));
            articalMapper.insertIntoArticleContent(articleAccessory);
        }
        return 0;
    }
    @Override
    public List<ArticleInfoDTO>selectByAuthorId(int Id)
    {
        List<Article> list=new ArrayList<>();
        list=articalMapper.selectByAuthorId(Id);
        List<ArticleInfoDTO> res=new ArrayList<>();
        if (list.size()==0) throw new BizException("查无此作者的文章");
        for (int i=0;i<list.size();i++)
        {
            ArticleInfoDTO tempDTO=new ArticleInfoDTO();
            Article tmpArticle =list.get(i);
            User user=userMapper.selectUserByPrimaryKey(tmpArticle.getA_Author());
            String sImgInfo=Base64.getEncoder().encodeToString(tmpArticle.getAPic());
            tempDTO.setAPic(sImgInfo);
            tempDTO.setAContent(tmpArticle.getAContent());
            tempDTO.setA_Name(tmpArticle.getA_Title());
            tempDTO.setaId(tmpArticle.getAId());
            tempDTO.setaAuthorName(user.getU_Name());
            tempDTO.setaAuthorImg(Base64.getEncoder().encodeToString(user.getU_Img()));
            tempDTO.setaDateTime(tmpArticle.getA_DateTime());
            tempDTO.setaAuthorId(tmpArticle.getA_Author());
            res.add(tempDTO);
        }
        return res;
    }
    @Override
    public List<String>selectPicContentByArticalId(int articalId)
    {
        List<String> ret=new ArrayList<>();
        List<byte[]> list=new ArrayList<>();
        list=articalMapper.selectPicByArticalId(articalId);
        if (list==null){ throw new BizException("文章中没有图片！");}
        for (int i=0;i<list.size();i++)
        {
            byte[] temp=list.get(i);
            String tempString;
            tempString=Base64.getEncoder().encodeToString(temp);
            ret.add(tempString);
        }
        return ret;
    }
}

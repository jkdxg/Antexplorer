package com.example.antexplorer.controller;

import com.example.antexplorer.exception.BizException;
import com.example.antexplorer.pojo.dto.ArticleInfoDTO;
import com.example.antexplorer.pojo.po.ArticleAccessory;
import com.example.antexplorer.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author 吴山烤禽
 * @package com.example.antexplorer.controller
 * @time 17:27
 * @discribe
 * @since 2020/2/26
 **/
@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired(required = false)
    ArticleService articleService;

    @GetMapping(value = "/getarticlebyprimarykey", produces = "application/json; charset=utf-8")
    public ArticleInfoDTO getArticleByKey(@RequestParam(value = "AId") int AId,@RequestParam(value = "Pic") int Pic) {
        ArticleInfoDTO ret = articleService.selectByPrimaryKey(AId);
        if (ret.getAContent()==null) {throw new BizException("查无此Id的文章");}
        //pic=1说明需要图片
        if (Pic==1)
        {
            List<String> accessoryList=new ArrayList<>();
            accessoryList=articleService.selectPicContentByArticalId(AId);
            ret.setArticleAccessoryList(accessoryList);
        }

        byte[] temp=Base64.getDecoder().decode(ret.getAPic());
        try
        {
            ByteToFile(temp);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }
    @GetMapping(value="/getarticlebytitle" ,produces = "application/json; charset=utf-8")
    public List<ArticleInfoDTO> getArticleByTitle(@RequestParam(value = "aTitle") String ATitle) {
        List<ArticleInfoDTO> ret = articleService.selectByTitle(ATitle);
        return ret;
    }
    @GetMapping(value = "/getarticlebyauthorid", produces = "application/json; charset=utf-8")
    public List<ArticleInfoDTO> getArticalByAuthorId(@RequestParam(value = "aAuthorId") int Id) {
        List<ArticleInfoDTO> ret = articleService.selectByAuthorId(Id);
        return ret;
    }

    @PostMapping(value="/uploadarticle", produces = "application/json; charset=utf-8")
    public int insertArticle(@RequestBody ArticleInfoDTO articleInfoDTO) {
        int res = 0;
        FileInputStream fis = null;
        OutputStream os = null;
//        //测试存图
//        String imgPath = "G:\\顾嘉扬\\cafe.jpg";
//        byte[] temp = image2Bytes(imgPath);
//        String imgSting = Base64.getEncoder().encodeToString(temp);
//        articleInfoDTO.setAPic(imgSting);
        //---------------------------//
        long l = System.currentTimeMillis();
        ArticleInfoDTO insertArtical = new ArticleInfoDTO();
        int aId = (int) (l % 1000);
        //检测是否有相同值的文章主键
        do {
            l = System.currentTimeMillis();
            aId = (int) (l % 1000);
            insertArtical = articleService.selectByPrimaryKey(aId);
        }
        while (insertArtical.getAContent() != null);


        res = articleService.insertArtical(articleInfoDTO, aId);
        return aId;
    }
    @GetMapping("/getpiccontent")
    public List<String> getArticleInnerPics(@RequestParam(value = "AId")int articleId)
    {
        List<String> ret= articleService.selectPicContentByArticalId(articleId);
        return ret;
    }
    public byte[] image2Bytes(String imgSrc) {
        FileInputStream fin;
        byte[] bytes = null;
        try {
            fin = new FileInputStream(new File(imgSrc));
            bytes = new byte[fin.available()];
            //将文件内容写入字节数组
            fin.read(bytes);
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bytes;
    }
    static void ByteToFile(byte[] bytes) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        BufferedImage bi1 = ImageIO.read(bais);
        try {
            File w2 = new File("00000003.png");//可以是jpg,png,gif格式
            ImageIO.write(bi1, "jpg", w2);//不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bais.close();
        }
    }
    private byte[] blobToBytes(Blob blob) {
        BufferedInputStream is = null;
        try {
            is = new BufferedInputStream(blob.getBinaryStream());
            byte[] bytes = new byte[(int) blob.length()];
            int len = bytes.length;
            int offset = 0;
            int read = 0;

            while (offset < len && (read = is.read(bytes, offset, len - offset)) >= 0) {
                offset += read;
            }
            return bytes;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                is.close();
                is = null;
            } catch (IOException e) {
                return null;
            }
        }
    }
}

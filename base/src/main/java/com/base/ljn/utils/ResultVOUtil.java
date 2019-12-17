package com.base.ljn.utils;

import com.base.ljn.vo.ResultVO;

import java.util.HashMap;
import java.util.Map;

public class ResultVOUtil {
    private Map<String, Object> data = new HashMap<String, Object>();

    public static ResultVO success(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO fail(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("失败");
        return resultVO;
    }

}

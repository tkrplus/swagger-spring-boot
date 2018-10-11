package com.github.tkrplus.swaggerspringboot.web.sample.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "サンプル更新用フォーム")
public class SampleMergeForm {

  @ApiModelProperty(name = "サンプル名", required = true, example = "ほげほげのサンプル")
  private String name;

  @ApiModelProperty(name = "数", example = "255", allowableValues = "range[1, 5]")
  private long count;

  @ApiModelProperty(name = "フラグ", required = true, example = "false")
  private boolean flag;

  public String getName() {
    return name;
  }

  public long getCount() {
    return count;
  }

  public boolean isFlag() {
    return flag;
  }
}

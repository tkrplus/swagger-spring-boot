package com.github.tkrplus.swaggerspringboot.web.sample.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "サンプル登録用フォーム")
public class SampleCreateForm {

  @ApiModelProperty(name = "サンプルID", required = true, example = "178852AD-DE4E-45EF-BC01-7820C403BE9C")
  private String id;

  @ApiModelProperty(name = "サンプル名", required = true, example = "ほげほげのサンプル")
  private String name;

  @ApiModelProperty(name = "数", example = "255", allowableValues = "range[1, 5]")
  private long count;

  @ApiModelProperty(name = "フラグ", required = true, example = "false")
  private boolean flag;

  public String getId() {
    return id;
  }

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

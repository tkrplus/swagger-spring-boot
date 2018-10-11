package com.github.tkrplus.swaggerspringboot.web.sample;

import com.github.tkrplus.swaggerspringboot.domain.sample.SampleModel;
import com.github.tkrplus.swaggerspringboot.web.sample.form.SampleCreateForm;
import com.github.tkrplus.swaggerspringboot.web.sample.form.SampleMergeForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@RestController
@RequestMapping("/api/sample")
@Api(tags = "サンプル", description = "サンプルの説明書き")
public class SampleController {

  @GetMapping()
  @ApiOperation(value = "サンプル一覧取得", notes = "サンプルの一覧を返却します。")
  public List<SampleModel> list() {
    final int listSize = 10;
    final List<SampleModel> list = LongStream.range(0, listSize)
        .mapToObj(SampleModel::createDefaultModel)
        .collect(Collectors.toList());

    return list;
  }

  @PostMapping
  @ApiOperation(value = "サンプル登録", notes = "サンプルを登録します。")
  public SampleModel create(@RequestBody final SampleCreateForm form) {
    SampleModel model = new SampleModel();
    BeanUtils.copyProperties(form, model);

    return model;
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "サンプル取得", notes = "指定したIDのサンプルを返却します。")
  public SampleModel get(
      @ApiParam(name = "サンプルID", required = true, example = "178852AD-DE4E-45EF-BC01-7820C403BE9C")
      @PathVariable("id") final String id) {
    SampleModel model = SampleModel.createDefaultModel();
    model.setId(id);

    return model;
  }

  @PutMapping(value = "/{id}")
  @ApiOperation(value = "サンプル更新",
      notes = "指定したIDのサンプルを更新します。\n" +
          "登録されていない場合は、登録を行います。")
  public SampleModel merge(
      @ApiParam(name = "サンプルID", required = true, example = "178852AD-DE4E-45EF-BC01-7820C403BE9C")
      @PathVariable("id") final String id,
      @RequestBody final SampleMergeForm form) {
    SampleModel model = new SampleModel();
    BeanUtils.copyProperties(form, model);
    model.setId(id);

    return model;
  }

  @DeleteMapping(value = "/{id}")
  @ApiOperation(value = "サンプル削除", notes = "指定したIDのサンプルを削除します。")
  public SampleModel delete(
      @ApiParam(name = "サンプルID", required = true, example = "178852AD-DE4E-45EF-BC01-7820C403BE9C")
      @PathVariable("id") final String id) {
    SampleModel model = SampleModel.createDefaultModel();
    model.setId(id);

    return model;
  }

}

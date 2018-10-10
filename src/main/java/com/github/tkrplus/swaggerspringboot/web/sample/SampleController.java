package com.github.tkrplus.swaggerspringboot.web.sample;

import com.github.tkrplus.swaggerspringboot.domain.sample.SampleModel;
import com.github.tkrplus.swaggerspringboot.web.sample.form.SampleCreateForm;
import com.github.tkrplus.swaggerspringboot.web.sample.form.SampleMergeForm;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

  @GetMapping()
  public List<SampleModel> list() {
    final int listSize = 10;
    final List<SampleModel> list = LongStream.range(0, listSize)
        .mapToObj(SampleModel::createDefaultModel)
        .collect(Collectors.toList());

    return list;
  }

  @PostMapping
  public SampleModel create(@RequestBody final SampleCreateForm form) {
    SampleModel model = new SampleModel();
    BeanUtils.copyProperties(form, model);

    return model;
  }

  @GetMapping(value = "/{id}")
  public SampleModel get(@PathVariable final String id) {
    SampleModel model = SampleModel.createDefaultModel();
    model.setId(id);

    return model;
  }

  @PutMapping(value = "/{id}")
  public SampleModel merge(
      @PathVariable final String id,
      @RequestBody final SampleMergeForm form) {
    SampleModel model = new SampleModel();
    BeanUtils.copyProperties(form, model);
    model.setId(id);

    return model;
  }

  @DeleteMapping(value = "/{id}")
  public SampleModel delete(@PathVariable final String id) {
    SampleModel model = SampleModel.createDefaultModel();
    model.setId(id);

    return model;
  }

}

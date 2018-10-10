package com.github.tkrplus.swaggerspringboot.domain.sample;

import com.github.tkrplus.swaggerspringboot.domain.Model;

import java.util.UUID;

public class SampleModel implements Model {
  static final long serialVersionUID = 1L;

  private String id;

  private String name;

  private long count;

  private boolean flag;

  static public SampleModel createDefaultModel() {
    final SampleModel model = new SampleModel();
    model.setId(UUID.randomUUID().toString());
    model.setName("sampleName");
    model.setCount(1L);
    model.setFlag(true);
    return model;
  }

  static public SampleModel createDefaultModel(final long index) {
    final SampleModel model = createDefaultModel();
    model.setName(model.getName() + String.valueOf(index));
    model.setCount(index);
    return model;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public boolean isFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }
}

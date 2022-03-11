package com.br.ControleTreinamento;

/**
 *
 * @author v103760
 */

    public class MyObject {

  private String name;
  private boolean bool1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBool1() {
        return bool1;
    }

    public void setBool1(boolean bool1) {
        this.bool1 = bool1;
    }

    public boolean isBool2() {
        return bool2;
    }

    public void setBool2(boolean bool2) {
        this.bool2 = bool2;
    }
  private boolean bool2;
  // Add getters and setters

  public MyObject(String name, boolean bool1, boolean bool2) {
    this.name = name;
    this.bool1 = bool1;
    this.bool2 = bool2;
  }


}

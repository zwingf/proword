package com.proword.service.BO;

import java.io.Serializable;

public class WordDictBO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1331119011261792891L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column word_dict.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column word_dict.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column word_dict.value
     *
     * @mbggenerated
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column word_dict.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column word_dict.id
     *
     * @return the value of word_dict.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column word_dict.id
     *
     * @param id the value for word_dict.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column word_dict.type
     *
     * @return the value of word_dict.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column word_dict.type
     *
     * @param type the value for word_dict.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column word_dict.value
     *
     * @return the value of word_dict.value
     *
     * @mbggenerated
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column word_dict.value
     *
     * @param value the value for word_dict.value
     *
     * @mbggenerated
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column word_dict.remark
     *
     * @return the value of word_dict.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column word_dict.remark
     *
     * @param remark the value for word_dict.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
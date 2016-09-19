//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.08 at 12:16:10 PM EDT 
//


package edu.emory.cci.bindaas.datasource.provider.aime4.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InferenceEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InferenceEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM}Entity">
 *       &lt;sequence>
 *         &lt;element name="imageEvidence" type="{uri:iso.org:21090}BL"/>
 *         &lt;element name="isPresent" type="{uri:iso.org:21090}BL" minOccurs="0"/>
 *         &lt;element name="typeCode" type="{uri:iso.org:21090}CD" maxOccurs="unbounded"/>
 *         &lt;element name="questionTypeCode" type="{uri:iso.org:21090}CD" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="annotatorConfidence" type="{uri:iso.org:21090}REAL" minOccurs="0"/>
 *         &lt;element name="description" type="{uri:iso.org:21090}ST" minOccurs="0"/>
 *         &lt;element name="label" type="{uri:iso.org:21090}ST" minOccurs="0"/>
 *         &lt;element name="questionIndex" type="{uri:iso.org:21090}INT" minOccurs="0"/>
 *         &lt;element name="comment" type="{uri:iso.org:21090}ST" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InferenceEntity", namespace = "gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM", propOrder = {
    "imageEvidence",
    "isPresent",
    "typeCode",
    "questionTypeCode",
    "annotatorConfidence",
    "description",
    "label",
    "questionIndex",
    "comment"
})
public class InferenceEntity
    extends Entity
{

    @XmlElement(required = true)
    protected BL imageEvidence;
    protected BL isPresent;
    @XmlElement(required = true)
    protected List<CD> typeCode;
    protected List<CD> questionTypeCode;
    protected REAL annotatorConfidence;
    protected ST description;
    protected ST label;
    protected INT questionIndex;
    protected ST comment;

    /**
     * Gets the value of the imageEvidence property.
     * 
     * @return
     *     possible object is
     *     {@link BL }
     *     
     */
    public BL getImageEvidence() {
        return imageEvidence;
    }

    /**
     * Sets the value of the imageEvidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link BL }
     *     
     */
    public void setImageEvidence(BL value) {
        this.imageEvidence = value;
    }

    /**
     * Gets the value of the isPresent property.
     * 
     * @return
     *     possible object is
     *     {@link BL }
     *     
     */
    public BL getIsPresent() {
        return isPresent;
    }

    /**
     * Sets the value of the isPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BL }
     *     
     */
    public void setIsPresent(BL value) {
        this.isPresent = value;
    }

    /**
     * Gets the value of the typeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CD }
     * 
     * 
     */
    public List<CD> getTypeCode() {
        if (typeCode == null) {
            typeCode = new ArrayList<CD>();
        }
        return this.typeCode;
    }

    /**
     * Gets the value of the questionTypeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the questionTypeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuestionTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CD }
     * 
     * 
     */
    public List<CD> getQuestionTypeCode() {
        if (questionTypeCode == null) {
            questionTypeCode = new ArrayList<CD>();
        }
        return this.questionTypeCode;
    }

    /**
     * Gets the value of the annotatorConfidence property.
     * 
     * @return
     *     possible object is
     *     {@link REAL }
     *     
     */
    public REAL getAnnotatorConfidence() {
        return annotatorConfidence;
    }

    /**
     * Sets the value of the annotatorConfidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link REAL }
     *     
     */
    public void setAnnotatorConfidence(REAL value) {
        this.annotatorConfidence = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link ST }
     *     
     */
    public ST getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link ST }
     *     
     */
    public void setDescription(ST value) {
        this.description = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link ST }
     *     
     */
    public ST getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link ST }
     *     
     */
    public void setLabel(ST value) {
        this.label = value;
    }

    /**
     * Gets the value of the questionIndex property.
     * 
     * @return
     *     possible object is
     *     {@link INT }
     *     
     */
    public INT getQuestionIndex() {
        return questionIndex;
    }

    /**
     * Sets the value of the questionIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link INT }
     *     
     */
    public void setQuestionIndex(INT value) {
        this.questionIndex = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link ST }
     *     
     */
    public ST getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ST }
     *     
     */
    public void setComment(ST value) {
        this.comment = value;
    }

}
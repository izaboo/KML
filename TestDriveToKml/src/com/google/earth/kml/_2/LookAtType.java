//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.20 at 11:55:08 AM CEST 
//


package com.google.earth.kml._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LookAtType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LookAtType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://earth.google.com/kml/2.1}ObjectType">
 *       &lt;all>
 *         &lt;element name="longitude" type="{http://earth.google.com/kml/2.1}angle180" minOccurs="0"/>
 *         &lt;element name="latitude" type="{http://earth.google.com/kml/2.1}angle90" minOccurs="0"/>
 *         &lt;element name="altitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="range" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tilt" type="{http://earth.google.com/kml/2.1}anglepos90" minOccurs="0"/>
 *         &lt;element name="heading" type="{http://earth.google.com/kml/2.1}angle360" minOccurs="0"/>
 *         &lt;element name="altitudeMode" type="{http://earth.google.com/kml/2.1}altitudeModeEnum" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LookAtType", propOrder = {
    "longitude",
    "latitude",
    "altitude",
    "range",
    "tilt",
    "heading",
    "altitudeMode"
})
public class LookAtType
    extends ObjectType
{

    @XmlElement(defaultValue = "0")
    protected Double longitude;
    @XmlElement(defaultValue = "0")
    protected Double latitude;
    @XmlElement(defaultValue = "0")
    protected Double altitude;
    protected Double range;
    @XmlElement(defaultValue = "0")
    protected Double tilt;
    @XmlElement(defaultValue = "0")
    protected Double heading;
    @XmlElement(defaultValue = "clampToGround")
    @XmlSchemaType(name = "string")
    protected AltitudeModeEnum altitudeMode;

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLongitude(Double value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLatitude(Double value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the altitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAltitude() {
        return altitude;
    }

    /**
     * Sets the value of the altitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAltitude(Double value) {
        this.altitude = value;
    }

    /**
     * Gets the value of the range property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRange() {
        return range;
    }

    /**
     * Sets the value of the range property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRange(Double value) {
        this.range = value;
    }

    /**
     * Gets the value of the tilt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTilt() {
        return tilt;
    }

    /**
     * Sets the value of the tilt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTilt(Double value) {
        this.tilt = value;
    }

    /**
     * Gets the value of the heading property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getHeading() {
        return heading;
    }

    /**
     * Sets the value of the heading property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setHeading(Double value) {
        this.heading = value;
    }

    /**
     * Gets the value of the altitudeMode property.
     * 
     * @return
     *     possible object is
     *     {@link AltitudeModeEnum }
     *     
     */
    public AltitudeModeEnum getAltitudeMode() {
        return altitudeMode;
    }

    /**
     * Sets the value of the altitudeMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AltitudeModeEnum }
     *     
     */
    public void setAltitudeMode(AltitudeModeEnum value) {
        this.altitudeMode = value;
    }

}

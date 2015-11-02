<%-- 
    Document   : navbar
    Created on : Oct 6, 2015, 10:00:59 AM
    Author     : Christian Choi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:select id="edit-state" path="state" class="form-control">
    <option value="AL" <c:if test="${address.state eq 'AL'}">selected</c:if>>AL</option>
    <option value="AK" <c:if test="${address.state eq 'AK'}">selected</c:if>>AK</option>
    <option value="AZ" <c:if test="${address.state eq 'AZ'}">selected</c:if>>AZ</option>
    <option value="AR" <c:if test="${address.state eq 'AR'}">selected</c:if>>AR</option>
    <option value="CA" <c:if test="${address.state eq 'CA'}">selected</c:if>>CA</option>
    <option value="CO" <c:if test="${address.state eq 'CO'}">selected</c:if>>CO</option>
    <option value="CT" <c:if test="${address.state eq 'CT'}">selected</c:if>>CT</option>
    <option value="DE" <c:if test="${address.state eq 'DE'}">selected</c:if>>DE</option>
    <option value="FL" <c:if test="${address.state eq 'FL'}">selected</c:if>>FL</option>
    <option value="GA" <c:if test="${address.state eq 'GA'}">selected</c:if>>GA</option>
    <option value="HI" <c:if test="${address.state eq 'HI'}">selected</c:if>>HI</option>
    <option value="ID" <c:if test="${address.state eq 'ID'}">selected</c:if>>ID</option>
    <option value="IL" <c:if test="${address.state eq 'IL'}">selected</c:if>>IL</option>
    <option value="IN" <c:if test="${address.state eq 'IN'}">selected</c:if>>IN</option>
    <option value="IA" <c:if test="${address.state eq 'IA'}">selected</c:if>>IA</option>
    <option value="KS" <c:if test="${address.state eq 'KS'}">selected</c:if>>KS</option>
    <option value="KY" <c:if test="${address.state eq 'KY'}">selected</c:if>>KY</option>
    <option value="LA" <c:if test="${address.state eq 'LA'}">selected</c:if>>LA</option>
    <option value="ME" <c:if test="${address.state eq 'ME'}">selected</c:if>>ME</option>
    <option value="MD" <c:if test="${address.state eq 'MD'}">selected</c:if>>MD</option>
    <option value="MA" <c:if test="${address.state eq 'MA'}">selected</c:if>>MA</option>
    <option value="MI" <c:if test="${address.state eq 'MI'}">selected</c:if>>MI</option>
    <option value="MN" <c:if test="${address.state eq 'MN'}">selected</c:if>>MN</option>
    <option value="MS" <c:if test="${address.state eq 'MS'}">selected</c:if>>MS</option>
    <option value="MO" <c:if test="${address.state eq 'MO'}">selected</c:if>>MO</option>
    <option value="MT" <c:if test="${address.state eq 'MT'}">selected</c:if>>MT</option>
    <option value="NE" <c:if test="${address.state eq 'NE'}">selected</c:if>>NE</option>
    <option value="NV" <c:if test="${address.state eq 'NV'}">selected</c:if>>NV</option>
    <option value="NH" <c:if test="${address.state eq 'NH'}">selected</c:if>>NH</option>
    <option value="NJ" <c:if test="${address.state eq 'NJ'}">selected</c:if>>NJ</option>
    <option value="NM" <c:if test="${address.state eq 'NM'}">selected</c:if>>NM</option>
    <option value="NY" <c:if test="${address.state eq 'NY'}">selected</c:if>>NY</option>
    <option value="NC" <c:if test="${address.state eq 'NC'}">selected</c:if>>NC</option>
    <option value="ND" <c:if test="${address.state eq 'ND'}">selected</c:if>>ND</option>
    <option value="OH" <c:if test="${address.state eq 'OH'}">selected</c:if>>OH</option>
    <option value="OK" <c:if test="${address.state eq 'OK'}">selected</c:if>>OK</option>
    <option value="OR" <c:if test="${address.state eq 'OR'}">selected</c:if>>OR</option>
    <option value="PA" <c:if test="${address.state eq 'PA'}">selected</c:if>>PA</option>
    <option value="RI" <c:if test="${address.state eq 'RI'}">selected</c:if>>RI</option>
    <option value="SC" <c:if test="${address.state eq 'SC'}">selected</c:if>>SC</option>
    <option value="SD" <c:if test="${address.state eq 'SD'}">selected</c:if>>SD</option>
    <option value="TN" <c:if test="${address.state eq 'TN'}">selected</c:if>>TN</option>
    <option value="TX" <c:if test="${address.state eq 'TX'}">selected</c:if>>TX</option>
    <option value="UT" <c:if test="${address.state eq 'UT'}">selected</c:if>>UT</option>
    <option value="VT" <c:if test="${address.state eq 'VT'}">selected</c:if>>VT</option>
    <option value="VA" <c:if test="${address.state eq 'VA'}">selected</c:if>>VA</option>
    <option value="WA" <c:if test="${address.state eq 'WA'}">selected</c:if>>WA</option>
    <option value="WV" <c:if test="${address.state eq 'WV'}">selected</c:if>>WV</option>
    <option value="WI" <c:if test="${address.state eq 'WI'}">selected</c:if>>WI</option>
    <option value="WY" <c:if test="${address.state eq 'WY'}">selected</c:if>>WY</option>


</form:select>

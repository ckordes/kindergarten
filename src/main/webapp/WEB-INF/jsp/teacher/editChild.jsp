<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 30.06.19
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Edit Child</title>
</head>
<body class="container">

<%@include file="../header.jsp" %>
<h4>Edit Child</h4>
<form:form method="post" modelAttribute="child">
    <form:hidden path="person.id"/>
    First Name: <form:input path="person.firstName"/>
    <form:errors path="person.firstName"/> <br/>
    Second Name: <form:input path="person.secondName"/>
    <form:errors path="person.secondName"/> <br/>
    Last Name: <form:input path="person.lastName"/>
    <form:errors path="person.lastName"/> <br/>
    PESEL: <form:input path="person.pesel"/>
    <form:errors path="person.pesel"/> <br/>
    ID Number: <form:input path="person.idNumber"/>
    <form:errors path="person.idNumber"/> <br/>
    Start hour: <form:input path="startHour"/>
    <form:errors path="startHour"/> <br/>
    End hour: <form:input path="endHour"/>
    <form:errors path="endHour"/> <br/>
    <h4>Child Address</h4>
    <form:hidden path="person.homeAddress.id"/>
    Street: <form:input path="person.homeAddress.street"/>
    <form:errors path="person.homeAddress.street"/> <br/>
    Building Number: <form:input path="person.homeAddress.numberBuilding"/>
    <form:errors path="person.homeAddress.numberBuilding"/> <br/>
    Flat Number: <form:input path="person.homeAddress.numberFlat"/>
    <form:errors path="person.homeAddress.numberFlat"/> <br/>
    Zip Code: <form:input path="person.homeAddress.zipCode"/>
    <form:errors path="person.homeAddress.zipCode"/> <br/>
    City: <form:input path="person.homeAddress.city"/>
    <form:errors path="person.homeAddress.city"/> <br/>
    Voievodyship: <form:input path="person.homeAddress.voievodyship"/>
    <form:errors path="person.homeAddress.voievodyship"/> <br/>
    <h4>Groups, Parents, Allergies</h4>
    Group:
    <form:select path="groupList" multiple="true" items="${allGroups}" itemValue="id" itemLabel="name"/>
    <form:errors path="groupList"/> <br/>

    Parents:
    <form:select path="parentList" multiple="true">
        <c:forEach items="${allParents}" var="parent">
            <option value="${parent.id}" ${child.parentList.contains(parent) ? 'selected="selected"' : ''}>${parent.person.fullName}</option>
        </c:forEach>
    </form:select>
    <form:errors path="parentList"/> <br/>

    Allergies:
    <form:select path="allergieList" multiple="true">
        <c:forEach items="${allAllergies}" var="allergie">
            <option value="${allergie.id}" ${child.allergieList.contains(allergie) ? 'selected="selected"' : ''}>${allergie.typeOfAllergie}</option>
        </c:forEach>
    </form:select>


    <%--    <form:select path="allergieList" items="${allAllergies}" itemLabel="typeOfAllergie" itemValue="id"/><br />--%>

    <input type="submit" value="Save">

    <br/>
    <form:errors path="*"/>
</form:form>

<%@include file="../footer.jsp" %>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
<form action="add">
	Enter Full Name: <input name="fullName"/><br><br>
	Enter password: <input type="password" name="password"><br><br>
	Enter emailId : <input type="email" name="emailId"/><br><br>
	Enter Mobile Number : <input name="contactNumber"/><br><br>
	H.No.: <input name="address.houseNumber"/><br><br>
	Street :  <input name="address.streetName"/><br><br>
	District : <input name="address.district"/><br><br>
	State : <input name="address.state"/><br><br>
	Country :<input name="address.country"/><br><br>
	Enter DOB : <input type="date" name="dateOfBirth"/><br><br>
	Enter Gender : <input name="gender"/><br><br>
	Enter MaritalStatus : <input name="maritalStatus"/><br><br>
	<input type="submit"/>
</form>
<%-- <spring:form action="add" modelAttribute="profile">
	Name: <spring:input path="fullName"/>
	emailId : <spring:input type="email" path="emailId"/>
	Mobile Number : <spring:input path="contactNumber"/>
	Address : <spring:input path="address" value="${profile.address }"/>
				H.No.: <spring:input path="houseNumber" value="${profile.address.houseNumber }"/>
				Street: <spring:input path="streetName" value="${profile.streetName }"/>
				District: <spring:input path="district"/>
				State: <spring:input path="state"/>
				Country: <spring:input path="country"/>
	DOB: <spring:input path="dateOfBirth"/>
	Gender: <spring:radiobutton path="gender" value="M" label="M" /> 
            <spring:radiobutton path="gender" value="F" label="F" />
	MaritalStatus: <spring:input path="maritalStatus"/>
	<input type="submit"/>
</spring:form> --%>
</body>
</html>




<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>IBM faq: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM faq: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM faq: Home</p>

<h3>資料查詢:</h3>
	

<ul>
  <li><a href='listAllFaq.jsp'>List</a> all faqs.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="faq.do" >
        <b>輸入問與答編號</b>
        <input type="text" name="id">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="faqSvc" scope="page" class="com.faq.model.FaqServiceImpl" />
   
 
  
 
<h3>問答管理</h3>

<ul>
  <li><a href='addFaq.jsp'>Add</a> a new Faq.</li>
</ul>

</body>
</html>
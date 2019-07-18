<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HEADER INCLUSION CODE -->

<jsp:include page="include/header.jsp"></jsp:include>
<div class="breadcrumbs">
	<section class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Profile</h1>
			</div>
			<div class="col-md-12">
				<div class="crumbs">
					<a href="#">Home</a> <span class="crumbs-span">/</span> <a href="#">User</a>
					<span class="crumbs-span">/</span> <span class="current">
						User Profile</span>
				</div>
			</div>
		</div>
		<!-- End row -->
	</section>
	<!-- End container -->
</div>
<!-- End breadcrumbs -->

	<section class="container main-content">
		
					<div class="user-profile">
						<div class="col-md-12">
							<div class="page-content">
								<h2>Profile</h2>
								<p style="font-size : 22px; color: black; font-weight: bold;">${ user.name }</p>
							
								<div class="ul_list ul_list-icon-ok about-user">
									<ul style="font-weight: bold;">
										<li><i class="icon-user" ></i>Gender  :  <span>${ user.gender }</span></li>
										<li><i class="icon-map-marker"></i>Country  :  <span>India</span></li>
										<li><i class="icon-gift"></i>Birthdate   :   <span>${ user.dob }</span></li>
										<li><i class="icon-phone-sign"></i>Contact-Number  :  <span>${ user.contactNumber }</span></li>
										<li><i class="icon-envelope" ></i>Email  :  <span>${ user.email }</span></li>
										<br>
										<li><i class="icon-check-empty" aria-hidden="true"></i>University   :   <span>${ user.university }</span></li>
										<li><i class="icon-check-empty"></i>Degree   :  <span>${ user.degree }</span></li>
									</ul>
									
									<c:set var="profession" value="${user.profession }" />
									
									<% 
												String current_user = (String)pageContext.getAttribute("profession");
												
												if(current_user.equals("Professor"))
												{
						 			%>
						 				<li><i class="icon-check-empty" aria-hidden="true"></i>University   :   <span>${ user.currentUniversity }</span></li>
										<li><i class="icon-check-empty"></i>Degree   :  <span>${ user.expertise }</span></li>
						 				
						 			<%	}	%>
						 			
								</div>
								<ul>
								<li style="float:right; font-size:27px;">
									<a href="updateProfile?data=${ user.email }" ><i class="icon-edit"></i></a>
								</li>
								</ul>
								<div class="clearfix"></div>
								
								<%
									int i = 0; 
								%>
								<c:forEach var="postItems" items="${posts}">
								<%
									i++;
								%>
								</c:forEach>
								
						</div><!-- End page-content -->
						</div><!-- End col-md-12 -->
						<div class="col-md-12">
							<div class="page-content page-content-user-profile">
								<div class="user-profile-widget">
									<h2>User Status</h2>
									<div class="ul_list ul_list-icon-ok">
										<ul>
											<li><i class="icon-question-sign"></i><a href="view_post">Posted Questions<span> ( <span><%=i%></span> ) </span></a></li>
										</ul>
										
									</div>
								</div><!-- End user-profile-widget -->
							</div><!-- End page-content -->
						</div><!-- End col-md-12 -->
					</div><!-- End user-profile -->
				</section>



<footer id="footer">
</footer>
<!-- FOOTER INCLUSION CODE -->

<jsp:include page="include/footer.jsp"></jsp:include>

<!-- FOOTER INCLUSION CODE -->

<!-- SCRIPT INCLUSION CODE -->

<jsp:include page="include/script.jsp"></jsp:include>

<!-- SCRIPT INCLUSION CODE -->
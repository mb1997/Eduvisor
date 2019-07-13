<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.application.model.*" %>
<!-- HEADER STARTS HERE -->
<jsp:include page="include/header.jsp" />
<!-- HEADER ENDS HERE -->

<div class="breadcrumbs">
		<section class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>Edit Profile</h1>
				</div>
				<div class="col-md-12">
					<div class="crumbs">
						<a href="#">Home</a>
						<span class="crumbs-span">/</span>
						<a href="#">user</a>
						<span class="crumbs-span">/</span>
						<span class="current">Edit Profile</span>
					</div>
				</div>
			</div><!-- End row -->
		</section><!-- End container -->
	</div><!-- End bread crumbs -->

<style>
	.page-content .boxedtitle{
		margin-left : 40%;
	}

</style>
	<section class="container main-content" style="margin-left:23%;">
		<div class="row">
			<div class="col-md-9">
				<div class="page-content">
					<div class="boxedtitle page-title"><h2>Edit Profile</h2></div>
					
						<div class="form-style form-style-4">
							<forms:form modelAttribute="user" action="/updateProfile?data=${user.email}">
								<div class="form-inputs clearfix">
									<p>
										<label>Name</label>
										<forms:input type="text" path="name" value="${user.name}"/>
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
									</p>
								</div>
								<div class="form-inputs clearfix">
									<p>
										<label>Date of Birth</label>
										<forms:input type="date" path="dob" value="${user.dob}" />
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
									</p>
								</div>
								<div class="form-inputs clearfix">
									<p>
										<label>Gender</label>
										<forms:input type="text" path="gender" value="${user.gender}" />
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
									</p>
								</div>
								<div class="form-inputs clearfix">
									<p>
										<label>Contact Number</label>
										<forms:input type="text" path="contactNumber" value="${user.contactNumber}"/>
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
									</p>
								</div>
								
								<div class=""><h3>Qualification</h3>
									<div class="form-inputs clearfix">
										<p>
											<label>University</label>
											<forms:input type="text" path="university"  value="${user.university}"/>
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
										</p>
									</div>
									<div class="form-inputs clearfix">
										<p>
											<label>Degree</label>
											<forms:input type="text" path="degree" value="${user.degree}"/>
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
										</p>
									</div>
									
									<% 
										if(request.getSession().getAttribute("user") != null)
										{
											User user = (User) request.getSession().getAttribute("user");
											String current_user=user.getProfession();
											
											if(current_user.equalsIgnoreCase("Professor"))
											{
						 			%>
									
									<div class="form-inputs clearfix">
										<p>
											<label>Current University</label>
											<forms:input type="text" path="currentUniversity" value="${user.currentUniversity}" />
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
										</p>
									</div>
									<div class="form-inputs clearfix">
										<p>
											<label>Expertise</label>
											<forms:input type="text" path="expertise" value="${user.expertise}" />
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
										</p>
									</div>
								
								<%
											}
										}
								%>
								</div>
								<p class="form-submit">
									<input type="submit" value="Update" class="button color small login-submit submit">
								</p>
							</forms:form>
						</div>
				</div><!-- End page-content -->
			</div><!-- End main -->
		</div>
	</section>


<!-- REMOVE FOOTER STARTS HERE -->
<jsp:include page="include/footer.jsp" />
<!-- REMOVE FOOTER ENDS HERE -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form"%>
<!-- ALL ELEMENTS WILL BE PLACED IN THE HEADER.JSP FILE
SO ONLY THING YOU NEED TO DO IS TO CREATE SECTION WITH CLASS CONTAINER AND MAIN-CONTENT

SAME AS FOOTER YOU ONLY NEED TO ADD FOOTER.JSP TO INCLUDE FOOTER

AND YOU NEED TO ADD SCRIPTS.JSP TO ADD JAVASCRIPTS TO YOUR CODE

YOU NEED TO ADD ALL THE 3 INCLUDE FILES THEN ONLY YOU CAN USE PAGE PROPERLY WITH TEMPLATE
-->



<!-- REMOVE HEADER STARTS HERE -->
<jsp:include page="include/header.jsp" />
<!-- REMOVE HEADER ENDS HERE -->

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
	</div><!-- End breadcrumbs -->

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
							<forms:form method="post" modelAttribute="user" action="update_profile">
								<div class="form-inputs clearfix">
									<p>
										<label>Name</label>
										<forms:input type="text" path="" />
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
									</p>
								</div>
								<div class="form-inputs clearfix">
									<p>
										<label>Birthdate</label>
										<forms:input type="text" path="" />
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
									</p>
								</div>
								<div class="form-inputs clearfix">
									<p>
										<label>Gender</label>
										<forms:input type="text" path="" />
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
									</p>
								</div>
								<div class=""><h3>Qualification</h3>
									<div class="form-inputs clearfix">
										<p>
											<label>University</label>
											<forms:input type="text" path="" />
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
										</p>
									</div>
									<div class="form-inputs clearfix">
										<p>
											<label>Degree</label>
											<forms:input type="text" path="" />
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
										</p>
									</div>
									<div class="form-inputs clearfix">
										<p>
											<label>Expertise</label>
											<forms:input type="text" path="" />
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
										</p>
									</div>
								</div>
								<div class="form-inputs clearfix">
									<p>
										<label>Contact Number</label>
										<forms:input type="text" path="" />
										<forms:errors path=""
										cssStyle="color: black; font-size: 15px;" />
									</p>
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
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
				<h1>Change Password</h1>
			</div>
			<div class="col-md-12">
				<div class="crumbs">
					<a href="#">Home</a> <span class="crumbs-span">/</span> <span
						class="current">Change Password</span>
				</div>
			</div>
		</div>
		<!-- End row -->
	</section>
	<!-- End container -->
</div>
<!-- End breadcrumbs -->
<style>
.main-content{
	margin-left:30%;
	
}
</style>
<section class="container main-content">
	<div class="login">
		<div class="row">
			<!-- LOGIN    (STARTS HERE) -->
			<div class="col-md-6">
				<div class="page-content">
					<h2>Change password</h2>
					<div class="form-style form-style-3">
					  
					<forms:form method="post" modelAttribute="" action="change_password">
							<div class="form-inputs clearfix">
								<p>
								<label class="required">New Password<span>*</span></label>
								<forms:input type="password" path="password" />
									<forms:errors path="name"
										cssStyle="color: black; font-size: 15px;" />
								</p>
								<p>
								<label class="required">Confirm New Password<span>*</span></label>
								<forms:input type="password" path="password" />
									<forms:errors path="name"
										cssStyle="color: black; font-size: 15px;" />
								</p>
							</div>
							<p class="form-submit">
							<input type="submit" value="Continue" class="button color small submit">
							</p>
						</forms:form>
	<!-- </div>  -->

					</div>
				</div>
				<!-- End page-content -->
			</div>
			<!-- End col-md-6 -->
			<!-- LOGIN    (ENDS HERE) -->

	<!-- End login -->
</section>
<!-- End container -->

<br><br><br><br><br><br><br>

<!-- REMOVE FOOTER STARTS HERE -->
<jsp:include page="include/footer.jsp" />
<!-- REMOVE FOOTER ENDS HERE -->

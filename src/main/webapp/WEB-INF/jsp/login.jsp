<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>
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
					<h1>Login</h1>
				</div>
				<div class="col-md-12">
					<div class="crumbs">
						<a href="#">Home</a>
						<span class="crumbs-span">/</span>
						<span class="current">Login</span>
					</div>
				</div>
			</div><!-- End row -->
		</section><!-- End container -->
	</div><!-- End breadcrumbs -->
	
	<section class="container main-content">
		<div class="login">
			<div class="row">
				<!-- LOGIN    (STARTS HERE) -->
				<div class="col-md-6">
					<div class="page-content">
						<h2>Login</h2>
						<div class="form-style form-style-3">
							<forms:form method="POST" modelAttribute="login" action="login">
								<forms:errors path="*" cssStyle="color: red; font-size: 20" />
								<div class="form-inputs clearfix">
									<p style="border:1px solid red">
										${loginError}
									</p>
									<p class="login-text">
										<forms:input type="text" path="email" />
										<i class="icon-user"></i>
									</p>
									<p class="login-password">
										<forms:input type="password" path="password" />
										<i class="icon-lock"></i>
										<a href="#">Forget</a>
									</p>
								</div>
								<p class="form-submit login-submit">
									<input type="submit" value="Log in" class="button color small login-submit submit">
								</p>
								<div class="rememberme">
									<label><input type="checkbox"> Remember Me</label>
								</div>
							</forms:form>
						</div>
					</div><!-- End page-content -->
				</div><!-- End col-md-6 -->
				<!-- LOGIN    (ENDS HERE) -->



				<!-- REGISTRATION  (STARTS HERE) -->
				<div class="col-md-6">
					<div class="page-content">
						<h2>Register Now</h2>
						<div class="form-style form-style-3">
							<forms:form method="POST" modelAttribute="register" action="register">
								<div class="form-inputs clearfix">
									<p style="border:1px solid red">
										${registerError}
									</p>
									<p>
										<label class="required">Name<span>*</span></label>
										<forms:input type="text" path="name" />
										<forms:errors path="name" cssStyle="color: red; font-size: 15px;" />
									</p>
									<p>
										<label class="required">E-Mail<span>*</span></label>
										<forms:input type="email" path="email" />
										<forms:errors path="email" cssStyle="color: red; font-size: 15px;" />
									</p>
									<p>
										<label class="required">Contact Number<span>*</span></label>
										<forms:input type="text" path="contactNumber" />
										<forms:errors path="contactNumber" cssStyle="color: red; font-size: 15px;" />
									</p>
									<p>
										<label class="required">Current Profession<span>*</span></label>
										<forms:select path="profession">
											<forms:option label="Select Profession" value="" />
											<forms:option value="Student" />
											<forms:option value="Professor" />
										</forms:select>
										<forms:errors path="profession" cssStyle="color: red; font-size: 15px;" />
									</p>
									<p>
										<label class="required">Password<span>*</span></label>
										<forms:input type="password" path="password" />
										<forms:errors path="password" cssStyle="color: red; font-size: 15px;" />
									</p>
								</div>
								<p class="form-submit">
									<input type="submit" value="Signup" class="button color small submit">
								</p>
							</forms:form>
						</div>
					</div><!-- End page-content -->
				</div><!-- End col-md-6 -->
				<!-- REGISTRATION    (ENDS HERE) -->



			</div><!-- End row -->
		</div><!-- End login -->
	</section><!-- End container -->





<br>
<br>
<!-- REMOVE FOOTER STARTS HERE -->
<jsp:include page="include/footer.jsp" />
<!-- REMOVE FOOTER ENDS HERE -->





<!-- REMOVE SCRIPTS STARTS HERE -->
<jsp:include page="include/script.jsp"></jsp:include>
<!-- REMOVE FOOTER ENDS HERE -->
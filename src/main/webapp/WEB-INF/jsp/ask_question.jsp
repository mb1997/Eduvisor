<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!-- HEADER INCLUSION CODE -->

<jsp:include page="include/header.jsp"></jsp:include>

<!-- HEADER INCLUSION CODE -->

<!-- PAGE HEADING -->
<div class="breadcrumbs">
	<section class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Ask Question</h1>
			</div>
			<div class="col-md-12">
				<div class="crumbs">
					<a href="#">Home</a> <span class="crumbs-span">/</span> <a href="#">Pages</a>
					<span class="crumbs-span">/</span> <span class="current">Ask
						Question</span>
				</div>
			</div>
		</div>
		<!-- End row -->
	</section>
	<!-- End container -->
</div>
<!-- End breadcrumbs -->
<!-- PAGE HEADING -->


<!-- MAIN PAGE -->

<section class="container main-content">
		<div class="row">
			<div class="col-md-12">
				
				<div class="page-content ask-question">
					<div class="boxedtitle page-title"><h2>Ask Question</h2></div>
					<div class="form-style form-style-3" id="question-submit">
						<form>
							<div class="form-inputs clearfix">
								<p>
									<label class="required">Question Title<span>*</span></label>
									<input type="text" id="question-title">
									<span class="form-description">Please choose an appropriate title for the question to answer it even easier .</span>
								</p>
								<p>
									<label class="required">Category<span>*</span></label>
									<span class="styled-select">
										<select>
											<option value="">Select a Category</option>
											<option value="1">Category 1</option>
											<option value="2">Category 2</option>
										</select>
									</span>
									<span class="form-description">Please choose the appropriate section so easily search for your question .</span>
								</p>
							</div>
							<div id="form-textarea">
								<p>
									<label class="required">Details<span>*</span></label>
									<textarea id="question-details" aria-required="true" cols="58" rows="8"></textarea>
									<span class="form-description">Type the description thoroughly and in detail .</span>
								</p>
							</div>
							<p class="form-submit">
								<input type="submit" id="publish-question" value="Publish Your Question" class="button color small submit">
							</p>
						</form>
					</div>
				</div><!-- End page-content -->
			</div><!-- End main -->
		</div><!-- End row -->
	</section><!-- End container -->
<br>
<br>
<!-- MAIN PAGE -->

<!-- FOOTER INCLUSION CODE -->

<jsp:include page="include/footer.jsp"></jsp:include>

<!-- FOOTER INCLUSION CODE -->

<!-- SCRIPT INCLUSION CODE -->

<jsp:include page="include/script.jsp"></jsp:include>

<!-- SCRIPT INCLUSION CODE -->
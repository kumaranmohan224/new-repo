package com.newdemo.framework.model;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import com.newdemo.framework.base.GlobalPaths;

public class TakeAssignmentPage {
	
	public WebElement instructorInfo(WebDriver driver, String strInfo)
	{
		return driver.findElement(By.xpath("//p[@class='instructor-info'][text()='" + strInfo + "']"));
	}
	public WebElement instructorEmail(WebDriver driver, String strInsEmail)
	{
		return driver.findElement(By.xpath("//p[@class='instructor-email']/a[text()='" + strInsEmail + "']"));
	}
	@FindBy(xpath="//span[@class='header-title-js'][text()='Section notifications']") public WebElement sectionNotifications;
	public WebElement instructorMessage(WebDriver driver, String strMessage)
	{
		return driver.findElement(By.xpath("//span[@class='hmAnnouncementNote'][text()='" + strMessage + "']"));
	}	
	@FindBy(xpath="//span[@class='toggle-text-js'][contains(text(),'bookmarks')]") public WebElement viewBookmarks;
	public WebElement bookmark(WebDriver driver, String strBookmarkName)
	{
		return driver.findElement(By.xpath("//div[@id='bookmarkPortletContainer']//a[text()='"+strBookmarkName+"']"));
	}	
	@FindBy(xpath="//div[contains(@class,'download-syllabus')]//a[@class='syllabus-text']") public WebElement downloadSyllabus;
	
	public WebElement assignment(WebDriver driver, String strAssignmentName)
	{
		return driver.findElement(By.xpath("//table[@class='assignment-list-content']//a[@class='assignment-title'][contains(text(),'"+strAssignmentName+"')]"));
	}
	public WebElement assignmentWebActivity(WebDriver driver, String strAssignmentName)
	{
		return driver.findElement(By.xpath("//a[@class='freeze assignment-title'][contains(text(),'"+strAssignmentName+"')]"));
	}
	
	public WebElement assignmentInstructions(WebDriver driver, String strInstruction)
	{
		return driver.findElement(By.xpath("//div[text()='Instructor message:']/../p[text()='"+strInstruction+"']"));
	}
	
	public WebElement selectAssignmentToTake(WebDriver driver, int index)
	{
		//commented by sayan
	//	return driver.findElement(By.xpath("(.//*[@class='assignment-list-content']/tbody/tr/td[2]/a)["+index+"]"));
		
	//	return driver.findElement(By.xpath("(.//*[@class='assignment-list-content']/tbody/tr/td/a[@class='assignment-title' or @class='freeze assignment-title'])[" + index + "]"));
		
		return driver.findElement(By.xpath("(//*[@class='assignment-list-content']/tbody/tr/td/a[contains(@class,'assignment-title')])[" + index + "]"));
		
	}
	
	public WebElement selectAssignmentToTakeByTitle(WebDriver driver, String assignmentName)
	{
		
		return driver.findElement(By.xpath("//*[@class='assignment-list-content']/tbody/tr/td/a[contains(@class,'assignment-title') and contains(text(),'" + assignmentName + "')]"));
		
	}
	
	public WebElement selectAssignmentToTakeByTitleIns(WebDriver driver, String assignmentName)
	{
		
		return driver.findElement(By.xpath("//a[@title='" + assignmentName + "']//span[contains(text(),'á, é, í, ó, ñ, ¿_,& , ñ, ¿, ¡, ÿ,æ, œ,')]"));
		
	}
	
	@FindBy(xpath="//a[@class='buttons btbl ok-btn'][text()='GO']") public WebElement takeAssignment;
	
	@FindBy(xpath="//input[@id='navbarSelect_input']") public WebElement questionNavigator;
	@FindBy(xpath="//button[@id='navbarEbook']") public WebElement eBook;	
	@FindBy(xpath="//button[@id='navbarPrint']") public WebElement print;
	@FindBy(xpath="//a[@class='printButton']") public WebElement newWindowPrint;
	@FindBy(xpath="//div[@id='print-header']//button[@class='print default']") public WebElement printDialogPrint;
	@FindBy(xpath="//div[@id='print-header']//button[@class='cancel']") public WebElement printDialogCancel;
	@FindBy(xpath="//a[@class='cancelButton']") public WebElement newWindowCancel;
	
	@FindBy(xpath="//button[@class='icon-next nextArrow']") public WebElement nextQuestion;
	@FindBy(xpath="//button[@class='icon-prev prevArrow']") public WebElement previousQuestion;
	@FindBy(xpath="(//p[@class='hm_questionTitle'])[1]") public WebElement questionTitle;	
	@FindBy(xpath=".//*[@id='TMML']//../textarea") public List<WebElement> worksheetAnswer;
	@FindBy(xpath=".//*[text()='being totally unconcerned']") public WebElement answerRdbtnWk;
	@FindBy(xpath="//*[@class='wk_select']") public WebElement answerSelectWk;
	@FindBy(xpath="//div[@class='wrp--fib-input']//input[contains(@class,'input--fib')]") public WebElement fillInTheBlankAnswer;
	@FindBy(xpath="//body[@id='tinymce']") public WebElement essayAnswer;	
	@FindBy(xpath="//button[@id='navbarSubmit'][@title='submit for grading']") public WebElement submitAssignment;
	@FindBy(xpath="//button[@id='navbarSaveExit']") public WebElement saveNExitAssignment;
	@FindBy(xpath="//input[@type='button'][@title='Cancel']") public WebElement cancelIncompleteAssignment;
	@FindBy(xpath="//div[text()='Wait! You have not completed all of the questions.']") public WebElement incompleteAssignment;
	@FindBy(xpath="//input[@type='button'][@title='Submit']") public WebElement confirmSubmit;
	//******changed by sayan
	@FindBy(xpath="//*[@class='tb-button-container']//child::input[1]") public WebElement confirmSubmit1;
	@FindBy(xpath="//*[@class='tb-button-container']//child::input[1]") public WebElement continueAnyway1;
	//******changed by sayan
	@FindBy(xpath="//span[text()='Points earned on auto-graded questions: ']/../span[@class='largeFont']") public WebElement subReportAutoGraded;
	@FindBy(xpath="//span[text()='Points you may earn on instructor-graded questions: ']/../span[@class='largeFont']") public WebElement subReportInstructorGraded;
	@FindBy(xpath="//span[text()='Total score: ']/../span[@class='largeFont']") public WebElement totalScore;
	@FindBy(xpath="//span[text()='This assignment is worth: ']/../span[@class='largeFont']") public WebElement assignmentWorth;
	@FindBy(xpath="//button[text()='Return to assignment list']") public WebElement returnToAssignmentList;
	
	@FindBy(xpath="//div[text()='Full credit for this question has been awarded to all students']") public WebElement fullCreditMessage;
	@FindBy(xpath="//div[text()='This question and its points have been dropped for all students']") public WebElement questionDroppedMessage;
	
	@FindBy(xpath="//button[text()='score this question']") public WebElement scoreThisQuestion;
	@FindBy(xpath="//div[text()='Wait! You have not completed all of the questions on this page. ']") public WebElement incompleteQuestion;
	@FindBy(xpath="//input[@type='button'][@title='Continue Anyway']") public WebElement continueAnyway;
	@FindBy(xpath="//span[text()='Score:']/..//span[@id='subReportScore']/../span[text()='Points']/../span[text()='%']/../span[@id='subReportScore']") public WebElement zeroScore;
	@FindBy(xpath="//span[@id='subReportScore']") public WebElement reportScore;
	@FindBy(xpath="//span[@class='score-percentage']") public WebElement reportPercentage;
	public WebElement reportScorePercentage(WebDriver driver, String strScore, String strPercentage)
	{
		return driver.findElement(By.xpath("//span[text()='Score:']/..//span[text()='"+strScore+"']/../span[text()='Points']/../span[text()='%']/../span[text()='"+strPercentage+"']"));
	}
	
	@FindBy(xpath="//span[@id='subReportScore']") public WebElement scorePoints;
	@FindBy(xpath="//div[@id='intermediaryScore']") public WebElement intermediaryScore;
	
	@FindBy(xpath="//p[text()='Thank you for your submission!']") public WebElement thankYouForSubmission;
	
	@FindBy(xpath="//div[@class='questionScoreControls']") public WebElement answerToleranceMessage;
	
	@FindBy(xpath="//a[text()='Ask your instructor a question']") public WebElement askInstructor;
	@FindBy(xpath="//textarea[@id='aid_message']") public WebElement askInstructorMessage;
	@FindBy(xpath="//button[@id='sndInsbutton']") public WebElement sendMessage;	
	
	@FindBy(xpath="//input[@id='studentupload_e']") public WebElement uploadFilesTakeAssignment;
	@FindBy(xpath="//span[@id='btnSubmit']/a") public WebElement submitFileAttach;	
	@FindBy(xpath="//b[@class='big_button']") public WebElement doneFileAtachment;	
	@FindBy(xpath="//div[@class='return-link']/a") public WebElement returnToSectionHome;
	
	@FindBy(xpath="//span[@class='weblinks']") public WebElement webLink;
	@FindBy(xpath="//li[@class='assign-blue-btn_cntrsm buttons btbl']") public WebElement doneWebActivity;	
	
	@FindBy(xpath="(//input[@type='file'])[1]") public WebElement txtFileUploadBackEnd;
	
	@FindBy(xpath="//p[text()='Your attempt has not yet been graded. Check back later.']") public WebElement bopaMessage;   //BOPA
	
	
	//======================STATIC ELEMENTS=================================
		//***************************INSTRUCTOR LOGIN PAGE******************************
		@FindBy(xpath="(//div[text()='Classes'])[1]") public WebElement eltClasses;
		@FindBy(xpath="(//div[text()='Results'])[1]") public WebElement eltResults;
		@FindBy(xpath="(//img[contains(@src,'classes.png')])[1]") public WebElement imgClasses;

		
		//======================DYNAMIC ELEMENTS================================
		public String _eltClassName = "(//div[text()='EXTERNALDATA'])[1]";
		
		//======================SIKULI IMAGES===================================
		public String SKIMG_ClassesIcon = GlobalPaths.strSikuliImagesPath + "\\ClassesIcon.png";
		
		
		//=================NAVIGATION ELEMENTS=====================================
		//========================NEW PAAM OBJECTS 20-APR-2015===========================
		@FindBy(xpath="//header") public WebElement eltHeader;
		@FindBy(xpath="(//canvas[@height=32])[1]") public WebElement cnvFlowButton;
		@FindBy(xpath="//img[contains(@src,'mhe_logo.png')]") public WebElement mheLogo;
		@FindBy(xpath=".//*[@id='flow']//div/div/div/canvas[@width='42']") public WebElement scrollInitiator;
		
		public String _eltLeftNavHeader = "(//div[text()='EXTERNALDATA'])[1]";
		public String _eltLeftNavSubHeader = "//div[text()='EXTERNALDATA']";
		
		//=========================PAAM DYNAMIC ELEMENTS==================================
//		public String _lstCourseNameCanvas = "//div[text()='EXTERNALDATA']/../../../div[1]/div[2]/div";
		public String _lstCourseNameCanvas = "//div[text()='EXTERNALDATA']/../../../div[2]/div/div";
		public String _eltLeftHeader = "(//div[text()='EXTERNALDATA'])[1]";
		
		public WebElement LeftNavigation_Header(WebDriver driver, String strHeader){
			return driver.findElement(By.xpath("(//img[contains(@src,'" + strHeader.toLowerCase() + ".png')])[1]"));
		}
		
		public WebElement LeftNavigation_Results(WebDriver driver, String strSubHeader){
			return driver.findElement(By.xpath("//div[contains(text(),'"+strSubHeader+"')]/../../../../../.."));
		}
		
		public WebElement LeftNavigation_SubHeaders(WebDriver driver, String strSubHeader){
			return driver.findElement(By.xpath("//div[contains(text(),'"+strSubHeader+"')]"));
		}
		
		public WebElement LeftNavigation_ClassesNResults(WebDriver driver, String strHeader){
			return driver.findElement(By.xpath("(//div[text()='" + strHeader + "'])[1]"));
		}
		
		@FindBy(xpath=".//*[@id='contentSet1']/div[2]/div[2]/button") public WebElement completeRegistration;
		
		
		/***********Menu Hamburger objects******************/
	@FindBy(xpath="//span[@class='icon-menu_hamburger']") public WebElement menuHamburgerIcon;
		/***********UserInfo Objects******************/
	@FindBy(xpath="//span[@class='menuLabel-icon icon-menu-userinfo']") public WebElement userInfoIcon;
	@FindBy(xpath="//*[@id='messagesSubMenu']") public WebElement userInfoMessages;
	@FindBy(xpath="//*[@id='notificationsSubMenu']") public WebElement userInfoNotifications;
	@FindBy(xpath="//*[@id='settingsSubMenu']") public WebElement userInfoMyAccount;
	@FindBy(xpath="//*[@id='helpSubMenu']") public WebElement userInfoHelp;
	@FindBy(xpath="//*[@id='signoutSubMenu']") public WebElement userInfoLogOut;
		/***********Assignment Tab objects******************/
	@FindBy(xpath="//*[@id='menu-assignments']/div") public WebElement assignmentsMainMenu;
	@FindBy(xpath="//*[@id='donowSubMenu']") public WebElement assignmentsTODO;
	@FindBy(xpath="//*[@id='calendarSubMenu']") public WebElement assignmentsCalendar;
		/***********Classes Tab objects******************/
	@FindBy(xpath="//*[@id='menu-classes']/div") public WebElement classesMainMenu;
	public WebElement clickCourseInClassesMenu(WebDriver driver,String courseTitle) throws Exception{
	return driver.findElement(By.xpath("//*[@id='menu-classes']/ul/li[text()='"+courseTitle+"']"));
	}
		/***********Results Tab objects******************/
	@FindBy(xpath="//*[@id='menu-results']/div") public WebElement resultsMainMenu;
	public WebElement clickCourseInResultsMenu(WebDriver driver,String courseTitle) throws Exception{
	return driver.findElement(By.xpath("//*[@id='menu-results']/ul/li[text()='"+courseTitle+"']"));
	}
		/***********Insight Tab object******************/
	@FindBy(xpath="//*[@id='menu-insight']/div") public WebElement insightMainMenu;

	//************************** New UI Changes Left Navigation **************************
			@FindBy(xpath="//div[@class='menu-text ']") public WebElement eltLeftMenuHiddenLHSNew;
			@FindBy(xpath="//*[@class='icon-menu_hamburger']") public WebElement eltFlowButtonLHSNew;
			@FindBy(xpath="//*[@id='userInfoMenu']") public WebElement eltUserInfoNew;
			@FindBy(xpath="//*[@id='messagesSubMenu']/button") public WebElement eltMessagesNew;
			@FindBy(xpath="//*[@id='notificationsSubMenu']/button") public WebElement eltNotificationsNew;
			@FindBy(xpath="//*[@id='settingsSubMenu']/button") public WebElement eltSettingsNew;
			@FindBy(xpath="//*[@id='helpSubMenu']/button") public WebElement eltHelpNew;
			
			@FindBy(xpath="//*[@id='ToDoMenu']/button") public WebElement eltToDoNew;
			@FindBy(xpath="//*[@id='CalendarMenu']/button") public WebElement eltCalendarNew;
			@FindBy(xpath="//*[@id='classesMenu']/button") public WebElement eltClassesNew;
			@FindBy(xpath="//*[@id='resultsMenu']/button") public WebElement eltResultsNew;
			@FindBy(xpath="//*[@id='insightsMenu']/button") public WebElement eltInsightsNew;
			@FindBy(xpath="//*[@id='logoutMenu']/button") public WebElement eltLogoutNew;
			
			//course direct
			@FindBy(xpath="//*[@id='classesMenu']/ul/li/button") public WebElement eltDefClassCourseNew;
			@FindBy(xpath="//*[@id='resultsMenu']/ul/li/button") public WebElement eltDefResCourseNew;
			
			public WebElement CourseNameClass(WebDriver driver, String strCourseName)
			{
					return driver.findElement(By.xpath("//*[@id='classesMenu']/ul/li/button[text()='" + strCourseName +"']"));
			}
			
			public WebElement CourseNameResults(WebDriver driver, String strCourseName)
			{
					return driver.findElement(By.xpath("//*[@id='resultsMenu']/ul/li/button[text()='" + strCourseName +"']"));
			}
			public WebElement assignmentSelectArrow(WebDriver driver, String strAssignmentName)
			{
					return driver.findElement(By.xpath("//h3[contains(text(),'" + strAssignmentName +"')]/../../../../../..//button"));
			}
			
			//workaround above one is not working
			//@FindBy(xpath="//*[@class='right course-list-container']//h3/../../../../../..//button") public WebElement assignment;
			public WebElement SelectAssignmentFromList(WebDriver driver, int AssignmentNumber)
			{
				return driver.findElement(By.xpath("(//*[@class='right course-list-container']//h3)["+AssignmentNumber+"]/../../../../../..//button"));
			}
			
			@FindBy(tagName="iframe") public WebElement frmQuestionFrame;
			@FindBy(xpath=".//button[(text() = 'Continue') or (text()='Begin')]") public WebElement btnEnterAssignment;
			@FindBy(xpath="//button[@class='intro__footer__start']") public WebElement startAssignment;
			//with h2
			@FindBy(xpath="//abbr[@title='Score answer']") public WebElement scoreAnswer;
			@FindBy(xpath=".//*[@id='nextScoreQ']") public WebElement scoreTheQuestion;
			@FindBy(xpath="//*[@class='modal__buttons']/button[2]") public WebElement YesScoreNow;
			@FindBy(xpath=".//abbr[@title='Next']") public WebElement next;
			@FindBy(xpath=".//*[@id='nextCtl']") public WebElement nextcheck;
			@FindBy(xpath=".//abbr[@title='previous']") public WebElement previous;
			@FindBy(xpath=".//*[@id='contentArea']/div[1]/div[2]/div/div[3]/div/input[2]") public WebElement fillInTheBlanksAnswer;
			@FindBy(css="#tinymce>p") public WebElement essay;
			@FindBy(xpath="(.//*[@name='answer'])") public List<WebElement> worsheet;
			@FindBy(xpath=".//*[@id='contentArea']/div[1]/div[2]/div/div[3]/div[1]/label/span") public WebElement trueorfalse;
			@FindBy(xpath="html/body/form[1]/div[2]/div[1]/div[2]/div/div[3]/div[1]/label") public WebElement trueorfalseNew;
			
			@FindBy(xpath=".//*[@class='header__exits']/button") public WebElement exit;
			@FindBy(xpath=".//*[@class='header__exits']/button[2]") public WebElement submit;
			@FindBy(xpath=".//*[@class='modal__buttons']/button[2]") public WebElement confirmSubmitAss;
			@FindBy(xpath=".//*[@class='modal-container']/button") public WebElement viewResults;
			@FindBy(xpath=".//*[@id='contentArea']/div[1]/div[2]/div/div[2]") public WebElement randomVariable;
			@FindBy(xpath=".//*[@class='answers--matching,']/li/div[1]/div") public List<WebElement> macthingOptionText;
			public WebElement selectOption(WebDriver driver, int index)
			{
				return driver.findElement(By.xpath("(.//*[@class='matching-ranking__row question--matching']/div//ul/li/div/span)["+index+"]"));
				
			}
			@FindBy(xpath=".//*[@id='contentArea']/div[1]/div[2]/div/div[3]/div/input[2]") public WebElement fillInTheBlanksAnswers;
			public WebElement selectOptionRanking(WebDriver driver, int index)
			{
				return driver.findElement(By.xpath("(.//*[@class='matching-ranking__row question--ranking']/div/ul/li/div/span)["+index+"]"));
				
			}
			public WebElement selectRankingAnswer1(WebDriver driver,int index)
			{
				return driver.findElement(By.xpath(".//*[@class='matching-ranking__options show']/ul/li["+index+"]"));
			}
			@FindBy(xpath=".//*[@class='matching-ranking__answer-options']/div/div[2]") public List<WebElement> rankingOptionsNew;
			@FindBy(id="answer_ifr") public WebElement iframe;
			@FindBy(xpath="(.//*[@class='matching-ranking__options show']/ul/li)[3]") public WebElement selectOptionNumbers;
			@FindBy(xpath="(.//*[@class='matching-ranking__options show']/ul/li)[2]") public WebElement selectOptionNumber1;
			
			@FindBy(xpath="(.//*[@class='answer--matching__choices']/button[2])[5]") public WebElement selectOptionNumberss;
			@FindBy(xpath="(.//*[@class='answer--matching__choices']/button[2])[3]") public WebElement selectOptionNumber3;
			@FindBy(xpath="(.//*[@class='answer--matching__choices']/button[4])[4]") public WebElement selectOptionNumber2;
			@FindBy(xpath="(.//*[@class='answer--matching__choices']/button[5])[2]") public WebElement selectOptionNumber4;
			@FindBy(xpath="(.//*[@class='answer--matching__choices']/button[6])[1]") public WebElement selectOptionNumber5;
			
			@FindBy(xpath=".//*[@class='matching-ranking__answer-options']/div") public List<WebElement> rankingOptions;
			public WebElement selectRankingAnswers2(WebDriver driver,int index)
			{
				return driver.findElement(By.xpath("(.//*[@class='matching-ranking__options show']/ul/li)["+index+"]"));
			}
			public WebElement selectRankingAnswers3(WebDriver driver,int index)
			{
				return driver.findElement(By.xpath("(.//*[@class='matching-ranking__options show']/ul/li)["+index+"]"));
			}
			public WebElement selectRankingAnswers4(WebDriver driver,int index)
			{
				return driver.findElement(By.xpath("(.//*[@class='matching-ranking__options show']/ul/li)["+index+"]"));
			}
			public WebElement selectRankingAnswers5(WebDriver driver,int index)
			{
				return driver.findElement(By.xpath("(.//*[@class='matching-ranking__options show']/ul/li)["+index+"]"));
			}
			public WebElement selectRankingAnswers1(WebDriver driver,int index)
			{
				return driver.findElement(By.xpath("(.//*[@class='matching-ranking__options show']/ul/li)["+index+"]"));
			}
			
			//CST-1897
			@FindBy(xpath=".//*[@id='SLE1_txt']") public WebElement dragableLaMesa;
			@FindBy(xpath=".//*[@class='target ui-droppable'][2]") public WebElement dragLaMesa;
			
			@FindBy(xpath=".//*[@id='SLE6_txt']") public WebElement dragableElRaloj;
			@FindBy(xpath=".//*[@class='target ui-droppable'][7]") public WebElement dragElRaloj;
			
			@FindBy(xpath=".//*[@id='SLE0_txt']") public WebElement dragableLaPared;
			@FindBy(xpath=".//*[@class='target ui-droppable'][1]") public WebElement dragLaPared;
			
			@FindBy(xpath=".//*[@id='SLE7_txt']") public WebElement dragableElEscritotio;
			@FindBy(xpath=".//*[@class='target ui-droppable'][8]") public WebElement dragElEscritotio;
			
			@FindBy(xpath=".//*[@id='SLE4_txt']") public WebElement dragableElTecho;
			@FindBy(xpath=".//*[@class='target ui-droppable'][5]") public WebElement dragElTecho;
			
			@FindBy(xpath=".//*[@id='SLE3_txt']") public WebElement dragableElMapa;
			@FindBy(xpath=".//*[@class='target ui-droppable'][4]") public WebElement dragElMapa;
			
			@FindBy(xpath=".//*[@id='SLE5_txt']") public WebElement dragableLaPizzare;
			@FindBy(xpath=".//*[@class='target ui-droppable'][6]") public WebElement dragLaPizzare;
			
			@FindBy(xpath=".//*[@id='SLE8_txt']") public WebElement dragableLaVentana;
			@FindBy(xpath=".//*[@class='target ui-droppable'][9]") public WebElement dragLaVentana;
			
			@FindBy(xpath=".//*[@id='SLE9_txt']") public WebElement dragableLaSilla;
			@FindBy(xpath=".//*[@class='target ui-droppable'][10]") public WebElement dragLaSilla;
			
			@FindBy(xpath=".//*[@id='SLE2_txt']") public WebElement dragableLosPupitries;
			@FindBy(xpath=".//*[@class='target ui-droppable'][3]") public WebElement dragLosPupitries;
			
			//MCQ
			
			@FindBy(xpath="(//*[contains(text(),'correct')])[2]") public WebElement multipleChoiceOption;
			@FindBy(xpath="//*[@class='source COI2 style_none']/img") public WebElement correctIndicator;
			
			//IRT
			@FindBy(xpath=".//*[contains(text(),'Visit question map')]/../../button[2]") public WebElement questionMap;
			public List<WebElement> QuestionsinMap(WebDriver driver, int questionNumber)
			{
				return driver.findElements(By.xpath(".//*[@class='question-map']/ul/li["+questionNumber+"]/button/span[3]"));
			}
			public WebElement QuestionsinMapText(WebDriver driver, int questionNumber)
			{
				return driver.findElement(By.xpath(".//*[@class='question-map']/ul/li["+questionNumber+"]/button/span[3]"));
			}
			
			@FindBy(xpath=".//*[@id='activity-map']//span[contains(text(),'close dialog')]/../../button") public WebElement closeQuestionMap;
			@FindBy(xpath=".//*[@class='modal__buttons']/button[1]") public WebElement cancelSubmit;
			
			//Q1/Q2 
			@FindBy(xpath=".//*[@id='ember709']/div/div/table[1]/tbody/tr/td/p") public WebElement questionText;
			@FindBy(xpath=".//*[@id='0_table0_cell_c0_r1']") public WebElement dropdownlistOne;
			@FindBy(xpath=".//*[@id='0_table0_cell_c0_r2']") public WebElement dropdownlistTwo;
			@FindBy(xpath=".//*[@id='0_table0_cell_c2_r2']") public WebElement dropdownlistThree;
			
			@FindBy(xpath=".//*[@id='0_table0_cell_c0_r3']") public WebElement inputBoxOne;
			@FindBy(xpath=".//*[@id='0_table0_cell_c2_r3']") public WebElement inputBoxTwo;
			
			@FindBy(xpath=".//*[@id='0_table0_cell_c4_r3']") public WebElement inputBoxThree;
			@FindBy(xpath=".//*[@id='jSheet_0_0']/tbody/tr[2]/td[2]") public WebElement inputBoxFour;
			@FindBy(xpath=".//*[@id='0_table0_cell_c1_r2']") public WebElement inputBoxFive;
			@FindBy(xpath=".//*[@id='0_table0_cell_c1_r3']") public WebElement inputBoxSix;
			@FindBy(xpath=".//*[@id='0_table0_cell_c1_r4']") public WebElement inputBoxSeven;

			
			
			@FindBy(xpath=".//*[@class='worksheet__main']/table[2]/tbody/tr[2]/td[4]") public WebElement costOfSales;
			@FindBy(xpath=".//*[@class='worksheet-wrap']/div/table[2]/tbody/tr[6]/td[7]") public WebElement costOfSalesFull;

			@FindBy(xpath=".//*[@class='question-wrap']/div/div/div/table/tbody/tr[1]/td/p") public WebElement questionThreeText;
			@FindBy(xpath=".//*[@id='0_table0_cell_c0_r2']") public WebElement dropdownOneQuesThree;
			@FindBy(xpath=".//*[@id='0_table0_cell_c1_r1']") public WebElement dropdownTwoQuesThree;
			@FindBy(xpath=".//*[@id='0_table0_cell_c1_r2']") public WebElement dropdownThreeQuesThree;
			@FindBy(xpath=".//*[@id='0_table0_cell_c3_r2']") public WebElement dropdownFourQuesThree;
			@FindBy(xpath=".//*[@id='0_table0_cell_c3_r1']") public WebElement dropdownFiveQuesThree;
			@FindBy(xpath=".//*[@id='0_table0_cell_c1_r7']") public WebElement dropdownSixQuesThree;
			@FindBy(xpath=".//*[@id='0_table0_cell_c3_r7']") public WebElement dropdownSevenQuesThree;
			@FindBy(xpath=".//*[@id='0_table0_cell_c1_r8']") public WebElement dropdownEightQuesThree;
			@FindBy(xpath=".//*[@id='0_table0_cell_c3_r8']") public WebElement dropdownNineQuesThree;
			@FindBy(xpath=".//*[@id='0_table0_cell_c3_r3']") public WebElement dropdownTenQuesThree;
			@FindBy(xpath=".//*[@id='0_table0_cell_c3_r3']") public WebElement autoValue;
			
			@FindBy(xpath=".//*[@id='growlMain']") public WebElement decimalPopup;
			@FindBy(xpath=".//*[@id='growlMain']/div/a") public WebElement decimalPopupClose;
			
			@FindBy(xpath=".//*[@id='ember469']/div/div[1]/div/div/button") public WebElement chechMyWork;
			@FindBy(xpath=".//*[@id='progress_bar_mgs']") public WebElement chechMyWorkStatus;
			@FindBy(xpath=".//*[@id='ember469']/div/div[2]/div/div/button") public WebElement returnToQuestion;
			@FindBy(xpath=".//*[@id='ember908']/button") public WebElement returnToQuestionOneFromMap;
			
			//IP
			@FindBy(xpath=".//*[@id='launcherImage']") public WebElement startVideo;
			@FindBy(xpath="(.//*[@class='ALE_next button'])[1]") public WebElement nextSlide;
			
			//MLG
			@FindBy(xpath=".//*[@id='mediaStart']/a/span[1]") public WebElement mediaStartButton;
			@FindBy(xpath=".//*[@id='mediaStart']/a/span[2]") public WebElement mediaPauseButton;
			@FindBy(xpath=".//*[@id='timeline']/div[1]/div[1]/div[2]/div[2]/span") public WebElement completionValue;
			
			//FBD
			@FindBy(xpath=".//*[@id='fbd-force']") public WebElement forceIcon;
			@FindBy(xpath=".//*[@id='force-modal']/div[2]/div[1]") public WebElement forceName;
			@FindBy(xpath=".//*[@id='force-modal']/div[3]/div/select") public WebElement origin;
			@FindBy(xpath=".//*[@title='Tension of support at D ']") public WebElement tensionD;
			@FindBy(xpath=".//*[@title='Tension of support at B ']") public WebElement tensionB;
			@FindBy(xpath=".//*[@title='Tension of support at C ']") public WebElement tensionC;
			@FindBy(xpath=".//*[@title='Weight of load ']") public WebElement weightOfLoad;
			@FindBy(xpath=".//*[@title='Reaction at C']") public WebElement reactionC;
			@FindBy(xpath=".//*[@id='awayforce-modal']") public WebElement awayForceModal;
			@FindBy(xpath=".//*[@id='towardsforce-modal']") public WebElement towardsForceModal;
			@FindBy(xpath=".//*[@id='force-modal']/div[5]/div[2]/input") public WebElement angle;
			@FindBy(xpath="html/body/div[1]/div[2]/div[1]/a[2]") public WebElement tickArrow;
			@FindBy(xpath="html/body/div[1]/div[2]/div[1]/a[1]") public WebElement closeModal;
			@FindBy(xpath=".//*[@id='fbd-delete']/div") public WebElement reset;
			
			//Highlighter
			
			@FindBy(xpath=".//*[@id='highlightcontainer_0']") public WebElement hightlightIndependant;
			
			public WebElement selectOptionMatchingText(WebDriver driver,int index)
			{
				return driver.findElement(By.xpath(".//*[@class='myAnswers']/div[3]/div[3]/div/div["+index+"]/div[2]"));
			}
			
		
			public WebElement selectOptionButton(WebDriver driver, int index)
			{
				return driver.findElement(By.xpath(".//*[@class='no-style-ul']/li["+index+"]"));
				
			}
			public WebElement selectOptionMatchingClassicText(WebDriver driver, int index)
			{
				return driver.findElement(By.xpath("(.//*[@class='myAnswers']/div[3]/div)["+index+"]"));
				
			}
			public WebElement selectOptionMatchingClassicButton(WebDriver driver, int index,int index1)
			{
				return driver.findElement(By.xpath("(.//*[@class='matching-ranking__content--width'])["+index+"]/div[3]/div[2]/ul/li["+index1+"]"));
				
			}
			@FindBy(xpath=".//*[@class='hm_questionTitle']") public WebElement questionTitles;
			
			@FindBy(xpath=".//*[@id='eztPopup']/div[3]/a") public WebElement takeAssignmentStdPreview;
			@FindBy(xpath=".//*[@class='assignment-header']/a") public WebElement assignmentHeader;  //added by sayan
			@FindBy(xpath=".//*[@id='navbarSelect_input']") public WebElement questionNavigatorStdPreview;
			@FindBy(xpath=".//*[@id='navbarSaveExit']") public WebElement saveNExit;
			@FindBy(xpath=".//*[@id='alaForm']/p") public WebElement timedMessage;
			@FindBy(xpath="//*[@id='alaForm']/input[7]") public WebElement startAssignmentStd;
			
		//	@FindBy(xpath=".//*[@id='alaForm']/input[6]") public WebElement resumeAssignmentStd;
			@FindBy(xpath=".//*[@id='alaForm']/input[contains(@value,'Submit') or contains(@value,'Resume')]") public WebElement resumeAssignmentStd;  //added by sayan
			
			@FindBy(xpath=".//*[@id='passwordForm']/label/input") public WebElement enterPassword;
		//	@FindBy(xpath=".//*[@id='passwordForm']/input[5]") public WebElement submitPassword;
			@FindBy(xpath=".//*[@id='passwordForm']/input[@value='Submit']") public WebElement submitPassword; //added by sayan
			
			@FindBy(xpath="//*[@id='timedorpassword']/form/p[contains(text(),'time limit')]") public WebElement timedMsg;
			@FindBy(xpath="//*[@id='timedorpassword']/form/p[contains(text(),'password')]") public WebElement passwordMsg;
		//	@FindBy(xpath="//*[@id='timedorpassword']/form/label/input[@type='password']") public WebElement enterPwd;
		//	@FindBy(xpath="//*[@id='timedorpassword']/form/input[@value='Start Assignment' or @value='Resume Assignment' or @value='Submit the Previous Attempt']") public WebElement startAssignmentBtn;
			@FindBy(xpath="//*[@id='timedorpassword']/form/input[@onclick]") public WebElement startAssignmentBtn;
			
			@FindBy(xpath="//button[contains(@title,'next question')]") public WebElement nextQuestionBtn;
			@FindBy(xpath="//table[@class='assignment-list-content']/tbody/tr/td[2]") public WebElement stdAssignmentTableClassic;
			
			//*********************sayan start
			
			@FindBy(xpath="//*[@id='eztPopup']/div[2]/div[2]/div[2]") public WebElement assignmentAttempt;
			
			//1. Matching type question native elements
			@FindBy(xpath="//*[@class='matching-ranking__choices']/div[1]") public WebElement matchingLeftStatement1;
			@FindBy(xpath="//*[@class='matching-ranking__choices']/div[2]") public WebElement matchingLeftStatement2;
			@FindBy(xpath="//*[@class='matching-ranking__answer-options']/div[1]/div[2]") public WebElement matchingRightStatement1;
			@FindBy(xpath="//*[@class='matching-ranking__answer-options']/div[2]/div[2]") public WebElement matchingRightStatement2;
			@FindBy(xpath="//*[@class='matching-ranking__answer-options']/div[1]/div/ul/li") public WebElement matchingRightStatement1_selector;
			@FindBy(xpath="//*[@class='matching-ranking__answer-options']/div[2]/div/ul/li") public WebElement matchingRightStatement2_selector;
			@FindBy(xpath="//*[@class='matching-ranking__options show']/ul/li[2]") public WebElement matchingOption1;
			@FindBy(xpath="//*[@class='matching-ranking__options show']/ul/li[3]") public WebElement matchingOption2;
			
			//2. Ranking type questions elements
			
			public WebElement rankingStatementText(WebDriver driver, int index)
			{
				return driver.findElement(By.xpath("//*[@class='matching-ranking__choices']/div[1]/div[" + index + "]/div[2]"));
				
			}
			
			public WebElement rankingStatement_selector(WebDriver driver, int index)
			{
				return driver.findElement(By.xpath("//*[@class='matching-ranking__choices']/div[1]/div[" + index + "]/div[1]/ul/li"));
				
			}
			
			public WebElement rankingOption(WebDriver driver, int index)
			{
				return driver.findElement(By.xpath("//*[@class='matching-ranking__options show']/ul/li[" + ++index + "]"));
				
			}
			
		/*	@FindBy(xpath="//*[@class='matching-ranking__choices']/div[1]/div[1]/div[2]") public WebElement rankingStatement1;
			@FindBy(xpath="//*[@class='matching-ranking__choices']/div[1]/div[2]/div[2]") public WebElement rankingStatement2;
			@FindBy(xpath="//*[@class='matching-ranking__choices']/div[1]/div[3]/div[2]") public WebElement rankingStatement3;
			@FindBy(xpath="//*[@class='matching-ranking__choices']/div[1]/div[4]/div[2]") public WebElement rankingStatement4;
			@FindBy(xpath="//*[@class='matching-ranking__choices']/div[1]/div[5]/div[2]") public WebElement rankingStatement5;
			@FindBy(xpath="//*[@class='matching-ranking__choices']/div[1]/div[1]/div[1]/ul/li") public WebElement rankingStatement1_selector;
			@FindBy(xpath="//*[@class='matching-ranking__choices']/div[1]/div[2]/div[1]/ul/li") public WebElement rankingStatement2_selector;
			@FindBy(xpath="//*[@class='matching-ranking__choices']/div[1]/div[3]/div[1]/ul/li") public WebElement rankingStatement3_selector;
			@FindBy(xpath="//*[@class='matching-ranking__choices']/div[1]/div[4]/div[1]/ul/li") public WebElement rankingStatement4_selector;
			@FindBy(xpath="//*[@class='matching-ranking__choices']/div[1]/div[5]/div[1]/ul/li") public WebElement rankingStatement5_selector;
			@FindBy(xpath="//*[@class='matching-ranking__options show']/ul/li[2]") public WebElement rankingOption1;
			@FindBy(xpath="//*[@class='matching-ranking__options show']/ul/li[3]") public WebElement rankingOption2;
			@FindBy(xpath="//*[@class='matching-ranking__options show']/ul/li[4]") public WebElement rankingOption3;
			@FindBy(xpath="//*[@class='matching-ranking__options show']/ul/li[5]") public WebElement rankingOption4;
			@FindBy(xpath="//*[@class='matching-ranking__options show']/ul/li[6]") public WebElement rankingOption5; */
			
			//3. Fill in the blanks question native elements
			@FindBy(xpath="//*[@class='myAnswers']/div[3]/div/input[2]") public WebElement fillInTheBlankAnswerNative;
			
			//7. Numeric question elements
			@FindBy(xpath="//*[@class='myAnswers']/div[2]") public WebElement numericExpression;
			@FindBy(xpath="//*[@class='myAnswers']/div[3]/div/input[2]") public WebElement answerNum;
			
			//8. Multiple Choice question elements
			public WebElement mcqChoice(WebDriver driver, String ans)
			{
				return driver.findElement(By.xpath("//*[@class='myAnswers']/div[3]/div/label/span[text()='" + ans + "']"));
				
			}
			
			//9. Worksheet answer elements
			@FindBy(xpath="//*[@class='myAnswers']/div[2]") public WebElement worksheetBody;
			@FindBy(xpath="//*[@class='myAnswers']/div[2]/table/tbody/tr/td/input") public WebElement listCompletionWorksheetAns;
			@FindBy(xpath="(//select)[2]") public WebElement mcqWorksheetAns;
			@FindBy(xpath="//*[@class='myAnswers']/div[2]/p[9]/input") public WebElement fillInTheBlankWorksheet;
			@FindBy(xpath="(//select)[3]") public WebElement trueOrFalseWorksheet;
			@FindBy(xpath="(//textarea)[1]") public WebElement essayWorksheet1;
			@FindBy(xpath="(//textarea)[2]") public WebElement essayWorksheet2;
			
			public WebElement mcqChoiceWorksheet(WebDriver driver, String ans)
			{
				return driver.findElement(By.xpath("(//select)[2]/option[text()='" + ans + "']"));
				
			}
			
			//Hints, Ebooks, Check my work elements
			@FindBy(xpath="//*[@class='footer-tab-container']/div[3]/a[1]") public WebElement hintBtn1;
			@FindBy(xpath="(//*[@class='modal-content'])[2]") public WebElement hintModal;
			@FindBy(xpath="(//*[@class='modal-content'])[2]/div[2]") public WebElement hintMsg;
			@FindBy(xpath="(//*[@class='modal-content'])[2]/div/span") public WebElement hintModalCloseBtn;
			@FindBy(xpath="//*[@class='qi_container footer-container']/a[contains(text(),'Check my work')]") public WebElement cmwBtn;
			@FindBy(xpath="(//*[@class='modal-content'])[7]/div[2]/div[1]") public WebElement cmwScoreDeductionText;
			@FindBy(xpath="(//*[@class='modal-content'])[7]/div[2]/div[2]") public WebElement cmwAttemptDeductionText;
			@FindBy(xpath="//*[@id='pregradeWarning']//child::button[text()='cancel']") public WebElement cmwCancel;
			@FindBy(xpath="//*[@id='pregradeDenial']//child::button[text()='cancel']") public WebElement cmwDenialCancel;
			@FindBy(xpath="//*[@id='pregradeWarning']//child::button[text()='ok']") public WebElement cmwAccept;
			@FindBy(xpath="(//*[@class='restriction-score'])[1]/span[2]") public WebElement hintMsgAtAssignStart;
			@FindBy(xpath="(//*[@class='restriction-score'])[2]/span[2]") public WebElement ebookMsgAtAssignStart;
			@FindBy(xpath="(//*[@class='restriction-score'])[3]/span[2]") public WebElement cmwMsgAtAssignStart;
			@FindBy(xpath="//*[@id='pregradeDenial']/div[2]/div/div[2]") public WebElement cmwMaxAttemptsUsed;
			@FindBy(xpath="//*[@class='questionScoreInfoStudent']") public WebElement pointValue;
			
			//CMW window elements
			@FindBy(xpath="//*[@class='input--fib input__post-sub--wrong input--numeric  ']") public WebElement cmwWrongInputCheck;
			@FindBy(xpath="//*[@class='input--fib input__post-sub--correct input--numeric  ']") public WebElement cmwCorrectInputCheck;
			
			
			//Post Submission View
			public WebElement questionScoreInfo(WebDriver driver, int number)
			{
				return driver.findElement(By.xpath("(//*[@class='questionScoreInfo']/span)[" + number + "]"));
				
			}
			
			@FindBy(xpath="(//*[@class='questionScoreInfo']/span)[1]") public WebElement questionScoreInfo1;
			
			//BOPA elements
			@FindBy(xpath="//*[@id='eztPopup']/div[2]/div[3]/p[4]") public WebElement bopaMsgOnStart;
			@FindBy(xpath="//*[@class='questionHeader']/div[4]/p") public WebElement bopaQsHeaderInfo;
			
			//Compound Deduction elements
			@FindBy(xpath="//*[@id='eztPopup']/div[2]/div[2]/div[2]") public WebElement prevAttemptNumber;
			@FindBy(xpath="//*[@id='eztPopup']/div[2]/div[2]/p[2]") public WebElement attemptDeductionMsg;
			@FindBy(xpath="//*[@class='subReportViewPanel']/div[1]/span[3]") public WebElement autoGradingFullMarks;
			
			//Full credit on completion
			@FindBy(xpath="//*[@id='infoHeader']/div/div[1]/div") public WebElement fullCreditOnCompletionText;
			@FindBy(xpath="//*[@id='subReportDetail']/span[1]") public WebElement fullCreditOnCompletionScore;
			@FindBy(xpath="(//*[@class='feedback_block'])[1]") public WebElement feedbackSolutionQs1;
			
			//**********************sayan end
			
			//12-Aug-2021
			//1st question mathml start -----
			@FindBy(xpath="//*[@class='question-stem-title']") public WebElement questionStem;
			@FindBy(xpath="//input[@type='text' and contains(@class,'numeric')]") public WebElement mathMLnumericInput1;
			//1st question mathml end -----
			//2nd question mathml start -----
			@FindBy(xpath="//input[contains(@class,'numeric')]") public WebElement mathMLnumericInput2;
			@FindBy(xpath="//*[@id='MathJax-Element-1-Frame']") public WebElement mathMLExpression1;
			@FindBy(xpath="//select[contains(@class,'select')]") public WebElement wkTrueOrFalseList;
			//2nd question mathml end -----
			//3rd question mathml start -----
			@FindBy(xpath="//*[contains(@data-mathml,'.208')]/../../..") public WebElement radioInputThirdQuestion;
			@FindBy(xpath="//*[contains(@data-mathml,'.208')]") public WebElement mathMLExpression2;
			//3rd question mathml end -----
			//4th question mathml start -----
			@FindBy(xpath="//*[contains(@data-mathml,'.200')]/../../..") public WebElement radioInputFourthQuestion;
			@FindBy(xpath="//*[contains(@data-mathml,'.200')]") public WebElement mathMLExpression3;
			//4th question mathml end -----
			//5th question mathml start -----
			@FindBy(xpath="//td[contains(text(),'Yes')]/..//input") public WebElement radioInputFifthQuestion1;
			@FindBy(xpath="(//input[contains(@class,'numeric')])[1]") public WebElement mathMLNumericInputFifthQs1;
			@FindBy(xpath="(//input[contains(@class,'numeric')])[2]") public WebElement mathMLNumericInputFifthQs2;
			//5th question mathml end -----
			
			//13-Aug-2021
			@FindBy(xpath="(//button[@id='mpPrevious'])[1]") public WebElement sectionBreakPrevBtnClassic;
			@FindBy(xpath="(//button[contains(@class,'mpNext')])[1]") public WebElement sectionBreakNextBtnClassic;
			@FindBy(xpath="//*[@id='palette_close']") public WebElement paletteCloseBtn;
			//palette -----
			public List<WebElement> spanishPaletteCharactersElementList(WebDriver driver) {
				return driver.findElements(By.xpath("//*[@id='palette_set']/a[@class='palette_key']"));
			}
			@FindBy(xpath="(//*[@id='palette_set']/a[@class=palette_key''])[1]") public WebElement spanishPaletteChar1;
			@FindBy(xpath="(//*[@id='palette_set']/a[@class=palette_key''])[2]") public WebElement spanishPaletteChar2;
			@FindBy(xpath="(//*[@id='palette_set']/a[@class=palette_key''])[3]") public WebElement spanishPaletteChar3;
			@FindBy(xpath="(//*[@id='palette_set']/a[@class=palette_key''])[4]") public WebElement spanishPaletteChar4;
			@FindBy(xpath="(//*[@id='palette_set']/a[@class=palette_key''])[5]") public WebElement spanishPaletteChar5;
			@FindBy(xpath="(//*[@id='palette_set']/a[@class=palette_key''])[6]") public WebElement spanishPaletteChar6;
			@FindBy(xpath="(//*[@id='palette_set']/a[@class=palette_key''])[7]") public WebElement spanishPaletteChar7;
			@FindBy(xpath="(//*[@id='palette_set']/a[@class=palette_key''])[8]") public WebElement spanishPaletteChar8;
			@FindBy(xpath="(//*[@id='palette_set']/a[@class=palette_key''])[9]") public WebElement spanishPaletteChar9;
			@FindBy(xpath="(//*[@id='palette_set']/a[@class=palette_key''])[10]") public WebElement spanishPaletteCha10;
			@FindBy(xpath="(//*[@id='palette_set']/a[@class=palette_key''])[11]") public WebElement spanishPaletteChar11;
			//1st world lang qs start -----
			@FindBy(xpath="//*[@draggable='true']//*[text()='Keylin*']/../..") public WebElement sourceDrag1;
			@FindBy(xpath="//*[@draggable='true']//*[text()='Olman']/../..") public WebElement sourceDrag2;
			@FindBy(xpath="//*[@draggable='true']//*[text()='William']/../..") public WebElement sourceDrag3;
			@FindBy(xpath="//*[@draggable='true']//*[text()='Juan Andrés']/../..") public WebElement sourceDrag4;
			@FindBy(xpath="//*[@draggable='true']//*[text()='Anlluly']/../..") public WebElement sourceDrag5;
			@FindBy(xpath="(//*[contains(@class,'ui-droppable') and contains(@class,'target')])[2]") public WebElement targetDrop1;
			@FindBy(xpath="(//*[contains(@class,'ui-droppable') and contains(@class,'target')])[5]") public WebElement targetDrop2;
			@FindBy(xpath="(//*[contains(@class,'ui-droppable') and contains(@class,'target')])[3]") public WebElement targetDrop3;
			@FindBy(xpath="(//*[contains(@class,'ui-droppable') and contains(@class,'target')])[4]") public WebElement targetDrop4;
			@FindBy(xpath="(//*[contains(@class,'ui-droppable') and contains(@class,'target')])[1]") public WebElement targetDrop5;
			//1st world lang qs end -----
			//2nd world lang qs start -----
			@FindBy(xpath="(//input[@class='wk_input spanish'])[1]") public WebElement fibSecondQs1;
			@FindBy(xpath="(//input[@class='wk_input spanish'])[2]") public WebElement fibSecondQs2;
			@FindBy(xpath="(//input[@class='wk_input spanish'])[3]") public WebElement fibSecondQs3;
			@FindBy(xpath="(//input[@class='wk_input spanish'])[4]") public WebElement fibSecondQs4;
			@FindBy(xpath="(//input[@class='wk_input spanish'])[5]") public WebElement fibSecondQs5;
			//2nd world lang qs end -----
			//3rd world lang qs start -----
			@FindBy(xpath="(//*[@draggable='true']//input[contains(@class,'FIB_input')])[1]") public WebElement fibThirdQs1;
			@FindBy(xpath="(//*[@draggable='true']//input[contains(@class,'FIB_input')])[3]") public WebElement fibThirdQs2;
			@FindBy(xpath="(//*[@draggable='true']//input[contains(@class,'FIB_input')])[4]") public WebElement fibThirdQs3;
			@FindBy(xpath="(//*[@draggable='true']//input[contains(@class,'FIB_input')])[2]") public WebElement fibThirdQs4;
			@FindBy(xpath="(//*[@draggable='true']//input[contains(@class,'FIB_input')])[5]") public WebElement fibThirdQs5;
			@FindBy(xpath="(//*[@draggable='true'])[1]//input") public WebElement sourceDragThirdQs1;
			@FindBy(xpath="(//*[@draggable='true'])[4]//input") public WebElement sourceDragThirdQs2;
			@FindBy(xpath="(//*[@draggable='true'])[5]//input") public WebElement sourceDragThirdQs3;
			@FindBy(xpath="(//*[@draggable='true'])[2]//input") public WebElement sourceDragThirdQs4;
			@FindBy(xpath="(//*[@draggable='true'])[3]//input") public WebElement sourceDragThirdQs5;
			public List<WebElement> thirdQsDropElementsList(WebDriver driver) {
				return driver.findElements(By.xpath("//*[contains(@class,'ui-droppable') and contains(@class,'target')]"));
			}
			//3rd world lang qs end -----
			//4th world lang qs start -----
			public List<WebElement> wkRadioInputFourthQsList(WebDriver driver) {
				return driver.findElements(By.xpath("//input[@class='wk_radio']"));
			}
			//4th world lang qs end -----
			//16-Aug-2021
			public List<WebElement> wkWorldLangFibPSVList(WebDriver driver) {
				return driver.findElements(By.xpath("//*[@class='wk_postTestUserResponse']"));
			}
			
			//17-Aug-2021
			@FindBy(xpath="//*[text()='Ok']") public WebElement unsupportedContentClassicModalCloseBtn;
			@FindBy(xpath="//*[@id='httpsUnsafeEztPopup']/div/div[1]") public WebElement unsupportedContentClassicModalText;

}



			

	


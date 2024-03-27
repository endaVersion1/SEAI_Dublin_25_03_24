describe('My First Cypress Test', () => {

  it('Visits the Login Page and then Checks for First Name Label', () => {
    // Visit the website
    cy.visit('https://robotsparebinindustries.com/');
  
    // Fill in the username and password fields
    cy.get('#username').click().type('maria');
    cy.get('#password').type('thoushallnotpass');
  
    // Click the submit button to log in
    cy.get("button[type='submit']").click();
  
    // Check if the Applications page is visible after login
    cy.contains('First name').should('be.visible');
  });
  
  it('Fill in the Sales Form and Submit', () => {
  });

});
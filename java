// Mobile Menu Toggle
document.querySelector('.mobile-menu').addEventListener('click', function() {
    document.querySelector('nav ul').classList.toggle('show');
});

// Smooth Scrolling for Navigation Links
document.querySelectorAll('nav a').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        e.preventDefault();
        
        const targetId = this.getAttribute('href');
        const targetElement = document.querySelector(targetId);
        
        window.scrollTo({
            top: targetElement.offsetTop - 80,
            behavior: 'smooth'
        });
        
        // Close mobile menu if open
        document.querySelector('nav ul').classList.remove('show');
    });
});

// Sticky Header on Scroll
window.addEventListener('scroll', function() {
    const header = document.querySelector('header');
    header.classList.toggle('sticky', window.scrollY > 0);
});

// Simple Cart Functionality (can be expanded)
document.querySelectorAll('.btn-small').forEach(button => {
    button.addEventListener('click', function(e) {
        e.preventDefault();
        const product = this.closest('.product-card');
        const productName = product.querySelector('h3').textContent;
        
        // In a real implementation, you would add to a cart array/object
        alert(`${productName} has been added to your bag!`);
    });
});

// Form Submission Handling
document.querySelector('.contact-form form').addEventListener('submit', function(e) {
    e.preventDefault();
    alert('Thank you for your message! We will get back to you soon.');
    this.reset();
});

document.querySelector('.newsletter form').addEventListener('submit', function(e) {
    e.preventDefault();
    const email = this.querySelector('input').value;
    alert(`Thank you for subscribing with ${email}!`);
    this.reset();
});

// Animation on Scroll
window.addEventListener('scroll', function() {
    const elements = document.querySelectorAll('.category-card, .product-card, .artisan-card, .delivery-card');
    
    elements.forEach(element => {
        const elementPosition = element.getBoundingClientRect().top;
        const screenPosition = window.innerHeight / 1.3;
        
        if (elementPosition < screenPosition) {
            element.style.opacity = '1';
            element.style.transform = 'translateY(0)';
        }
    });
});

// Initialize elements with opacity 0 for animation
document.addEventListener('DOMContentLoaded', function() {
    const elements = document.querySelectorAll('.category-card, .product-card, .artisan-card, .delivery-card');
    
    elements.forEach(element => {
        element.style.opacity = '0';
        element.style.transform = 'translateY(20px)';
        element.style.transition = 'all 0.5s ease';
    });
    
    // Trigger animation for hero elements
    setTimeout(() => {
        document.querySelector('.hero-content').style.opacity = '1';
        document.querySelector('.hero-content').style.transform = 'translateY(0)';
    }, 300);
});

// Set initial styles for hero content
document.querySelector('.hero-content').style.opacity = '0';
document.querySelector('.hero-content').style.transform = 'translateY(20px)';
document.querySelector('.hero-content').style.transition = 'all 0.8s ease';

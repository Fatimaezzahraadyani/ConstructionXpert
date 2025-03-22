<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<main>
  <!-- Hero -->
  <section class="hero">
    <h2>Unleash Your Productivity with ConstructionXpert</h2><br />
    <p>Say goodbye to distractions and welcome smooth project management. ConstructionXpert helps you organize, prioritize, and achieve your construction goals, all within an intuitive app.</p><br />

    <a href="AllProject" class="btn btn-primary">Start</a>
  </section>

  <!-- Two Column Section -->
  <section class="info">
    <div class="col">
      <h2>Work Smarter, Not Harder</h2><br />
      <p>With FocusFlow, you get powerful tools to streamline your day. From smart task lists to time tracking, everything you need is at your fingertips.</p>
    </div>
    <div class="col">
      <img class="info-image" src="https://images.unsplash.com/photo-1588534510807-86dfb5ed5d5b" alt="">
    </div>
  </section>

  <!-- Course Details -->

  <!-- Feature Cards -->
  <section class="features">
    <h2>Here's What You'll Achieve</h2>
    <div class="feature-cards">
      <div class="feature-card">
        <h3>Custom Task Views</h3>
        <p>Organize your tasks your way, by priority, due date, or project. FocusFlow adapts to your workflow effortlessly.</p>
      </div>
      <div class="feature-card">
        <h3>Real-Time Collaboration</h3>
        <p>Share projects with your team and stay in sync with instant updates and built-in chat.</p>
      </div>
      <div class="feature-card">
        <h3>Focus Mode</h3>
        <p>Block distractions and dive deep into your work with our one-click focus timer.</p>
      </div>
    </div>
  </section>

  <section class="call-to-action">
    <h2>Ready to Transform Your Day?</h2>
    <button class="cta">Get Started Now</button>
  </section>

  <section class="five-steps">


  </section>

</main>
<style>

@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap');

* {
  margin: 0;
  box-sizing: border-box;
}

body {

}

h1 {
  font-family: 'Montserrat', 'sans-serif';
  font-size: 3rem;
  letter-spacing: 0.1rem;
}

h2 {
  font-family: 'Montserrat', 'sans-serif';
  font-size: 3rem;
  letter-spacing: 0.1rem;
}

h3 {
  font-family: 'Montserrat', 'sans-serif';
  font-size: 2rem;
  letter-spacing: 0.1rem;
}

p, a {
  font-family: 'Poppins', 'sans-serif';
  font-size: 1.2rem;
  letter-spacing: 0.1rem;
}

main {
  display: flex;
  flex-direction: column;
}

.hero {
  position: relative;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  min-height: 60vh;
  background-image: url('https://images.unsplash.com/photo-1484522676511-0f51cc572bb0');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  color: white;
  text-align: center;
  padding: 2rem;
  z-index: 1;
}

.hero::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.8);
  z-index: -1;
}

.hero h2 {
  max-width: 1000px;
}

.hero p {
  max-width: 1000px;
}

.info {
  display: flex;
  flex-wrap: wrap;
  margin-top: 4rem;
  align-items: center;
  justify-content: center;
  max-width: 1024px;
  margin-left: auto;
  margin-right: auto;
}

.col {
  flex: 1 1 300px;
  max-width: 640px;
  padding: 2rem;
}

.col .info-image {
  max-width: 400px;
  width: 100%;
  height: auto;
  aspect-ratio: 1/1;
  object-fit: cover;
  border-top-right-radius: 2rem;
  border-bottom-left-radius: 2rem;
  display: block;
}

.course-details {
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  background-color: black;
  color: white;
  padding: 4rem;
  margin-top: 4rem;
  min-height: 60vh;
}

.course-details .col {
  display: flex;
  flex-direction: column;
  max-width: 1000px;
  width: 100%;
}

.course-details .col img {
  max-width: 100%;
  height: auto;
  display: block;
  margin-top: 2rem;
  margin-bottom: 2rem;
}

.text-steelblue {
  color: steelblue;
}

button {
  display: inline-block;
  margin: 0 auto;
  margin-top: 2rem;
  padding: 1rem;
  background-color: steelblue;
  color: white;
  border: none;
  border-radius: 0.4rem;
  cursor: pointer;
  font-size: 1rem
}

.features {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 2rem;
  min-height: 60vh;
  margin-top: 4rem;
  padding: 0 2rem;
}

.feature-cards {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  gap: 1rem;
}

.feature-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 2rem;
  border: 2px solid lightsteelblue;
  border-radius: 1rem;
  box-shadow: 0 1rem 2rem rgba(0,0,0,0.1);
  max-width: 300px;
  width: 100%;
  text-align: center;
  min-height: 20vh;
}

.call-to-action {
  display: flex;
  flex-direction: column;
  background-color: black;
  text-align: center;
  min-height: 30vh;
  justify-content: center;
  padding: 4rem;
  color: white;
  margin-top: 4rem;
}

.call-to-action h2 {
  max-width: 1000px;
  margin: auto;
}

.cta {
  background-color: steelblue;
}

.five-steps {
  display: flex;
  flex-wrap: wrap;
  margin-top: 4rem;
  align-items: center;
  justify-content: center;
  max-width: 1000px;
  margin-left: auto;
  margin-right: auto;
}

.checklist {
  list-style: none;
  padding: 0;
}

.five-steps-image {
  max-width: 350px;
  width: 100%;
  height: auto;
  aspect-ratio: 1/1;
  object-fit: cover;
  display: block;
}


</style>
</html>
# Software Engineering Project: Two Factor Authentication Project

## Overview
This software project involves the creation of  a basic authenticator application for use in a two-factor authentication (2FA) system. This project is focused on the design and 
development of an application that uses a time-based one-time password system: after synchronizing the application with a website, both the site and the application will simultaneously 
but independently generate and refresh a single-use password. The user receives the password from the application and enters it into the website or device, where it is validated, 
allowing the user to log in.

Time-based One-Time Password (TOTP) is a system of 2FA that involves generating a single-use password that can be used to log in to the associated user account. The password is
limited by a timer that causes the password to refresh if it is not used within a certain time frame. In this way, a user's account is protected from unexpected logins by preventing
anyone besides the user with the authenticator application from having enough time to guess or otherwise discover the single-use password.

In order to develop and test such an application, it would also be necessary to develop a basic website with a login system. This scope of this project therefore covers both 
mobile app development and basic web development, although the intent of the project is to focus on the application aspect. The application will be designed with the intent
of understanding and implementing the underlying mechanisms within the TOTP algorithm. 

## Team Members
Daniel Dong (daniel.p.dong@vanderbilt.edu) 

Zach Borromeo (zachary.p.borromeo@vanderbilt.edu)

Sharjeel Khan (muhammad.sharjeel.m.khan@vanderbilt.edu)

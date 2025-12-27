Write-Host "Initializing Git repository..." -ForegroundColor Green
git init

Write-Host "Adding all files..." -ForegroundColor Green
git add .

Write-Host "Creating initial commit..." -ForegroundColor Green
git commit -m "Initial commit: Food App Spring Boot application"

Write-Host "Adding remote origin..." -ForegroundColor Green
git remote add origin https://github.com/abinav000/foodapp.git

Write-Host "Setting main branch..." -ForegroundColor Green
git branch -M main

Write-Host "Pushing to GitHub..." -ForegroundColor Green
git push -u origin main

Write-Host "Done! Repository available at: https://github.com/abinav000/foodapp" -ForegroundColor Yellow
Read-Host "Press Enter to continue"
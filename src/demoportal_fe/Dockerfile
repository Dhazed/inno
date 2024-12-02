# Dockerfile
# Stage 1: Build Angular 18 App
FROM node:23.2-alpine AS builder

# Install Angular CLI globally
RUN npm install -g @angular/cli@18.1.3
WORKDIR /app
# Copy package files to install dependencies
COPY package.json ./
COPY .npmrc ./
# Install dependencies
#RUN npm install --save-dev @lmdb/lmdb-linux-x64@3.1.6
RUN npm install
# Copy the rest of the application files
COPY . .
# Build the Angular app for production
RUN ng build --configuration=production

# Fase 2: servire l'applicazione Angular usando nginx
FROM nginx:alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=builder /app/dist/demoportal_fe/browser /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]

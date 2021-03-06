FROM node:10

WORKDIR /usr/src/app

ENV PORT 4000
ENV HOST 0.0.0.0

COPY package*.json ./
RUN npm install --only=production

COPY . .

RUN npm run build

CMD npm run prod
